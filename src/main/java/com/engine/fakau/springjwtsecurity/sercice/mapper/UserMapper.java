package com.engine.fakau.springjwtsecurity.sercice.mapper;

import com.engine.fakau.springjwtsecurity.domaine.User;
import com.engine.fakau.springjwtsecurity.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements IMapper<User, UserDTO> {

    @Override
    public User toEntity(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO toDTO(User user) {
        return null;
    }
}
