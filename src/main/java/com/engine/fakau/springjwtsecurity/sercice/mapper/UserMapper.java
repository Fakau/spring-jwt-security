package com.engine.fakau.springjwtsecurity.sercice.mapper;

import com.engine.fakau.springjwtsecurity.domaine.User;
import com.engine.fakau.springjwtsecurity.sercice.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserMapper implements IMapper<User, UserDTO> {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setCreationUser(userDTO.getCreationUser());
        user.setCreationDate(userDTO.getCreationDate());
        user.setUpdateUser(userDTO.getUpdateUser());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setEnabled(userDTO.isEnabled());
        user.setRoles(userDTO.getRoleDTOs()
                .stream()
                .map(roleMapper::toEntity)
                .collect(Collectors.toList()));
        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setCreationUser(user.getCreationUser());
        userDTO.setCreationDate(user.getCreationDate());
        userDTO.setUpdateUser(user.getUpdateUser());
        userDTO.setLogin(user.getLogin());
        userDTO.setEmail(user.getEmail());
        userDTO.setEnabled(user.isEnabled());
        userDTO.setRoleDTOs(user.getRoles()
                .stream()
                .map(roleMapper::toDTO)
                .collect(Collectors.toList()));
        return userDTO;
    }
}
