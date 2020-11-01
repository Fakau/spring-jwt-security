package com.engine.fakau.springjwtsecurity.sercice.mapper;

import com.engine.fakau.springjwtsecurity.domaine.Role;
import com.engine.fakau.springjwtsecurity.dto.RoleDTO;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper implements IMapper<Role, RoleDTO> {
    @Override
    public Role toEntity(RoleDTO roleDTO) {
        return null;
    }

    @Override
    public RoleDTO toDTO(Role role) {
        return null;
    }
}
