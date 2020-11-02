package com.engine.fakau.springjwtsecurity.sercice.serviceImpl;

import com.engine.fakau.springjwtsecurity.config.JwtTokenUtil;
import com.engine.fakau.springjwtsecurity.domaine.User;
import com.engine.fakau.springjwtsecurity.exception.BadRequestException;
import com.engine.fakau.springjwtsecurity.repository.UserRepository;
import com.engine.fakau.springjwtsecurity.sercice.UserService;
import com.engine.fakau.springjwtsecurity.sercice.dto.UserDTO;
import com.engine.fakau.springjwtsecurity.sercice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
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
        authenticate(login, password);
        User user = userRepository.findOneByLogin(login)
                .orElseThrow( () -> new UsernameNotFoundException("User not found with username:"));
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

}
