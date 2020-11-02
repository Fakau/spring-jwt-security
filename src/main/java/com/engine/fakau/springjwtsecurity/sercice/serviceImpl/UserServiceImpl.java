package com.engine.fakau.springjwtsecurity.sercice.serviceImpl;

import com.engine.fakau.springjwtsecurity.config.JwtTokenUtil;
import com.engine.fakau.springjwtsecurity.domaine.User;
import com.engine.fakau.springjwtsecurity.exception.BadRequestException;
import com.engine.fakau.springjwtsecurity.exception.EmailAlreadyExistException;
import com.engine.fakau.springjwtsecurity.exception.UserAlreadyExistException;
import com.engine.fakau.springjwtsecurity.repository.UserRepository;
import com.engine.fakau.springjwtsecurity.sercice.UserService;
import com.engine.fakau.springjwtsecurity.sercice.dto.UserDTO;
import com.engine.fakau.springjwtsecurity.sercice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        if(user.getId() != null ){
            throw new BadRequestException("Cannot add a new user account with id != null");
        }
        if (userRepository.findOneByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException("email exist");
        }
        if (userRepository.findOneByLogin(user.getLogin()).isPresent()) {
            throw new UserAlreadyExistException("User exist");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        if(user.getId() == null ){
            throw new BadRequestException("Cannot update a new user account with id == null");
        }
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    public String authentication(String login, String password) throws Exception {
        User user = userRepository.findOneByLogin(login)
               .orElseThrow( () -> new UsernameNotFoundException("User not found with login" + login));
        authenticate(login, password);
        String token = jwtTokenUtil.generateToken(user);
        return token;
    }
    @Override
    public Optional<UserDTO> findOneByLogin(String login){
        return userRepository.findOneByLogin(login)
                .map(userMapper::toDTO);
    }
    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByLogin(username).get();
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> authorities = new ArrayList<>();
                user.getRoles().forEach(item -> {
                    authorities.add(new SimpleGrantedAuthority("ROLE_".concat(String.valueOf(item.getNomRole()))));
                });
                return authorities;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getLogin();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return user.isEnabled();
            }
        };
        return userDetails;
    }
}
