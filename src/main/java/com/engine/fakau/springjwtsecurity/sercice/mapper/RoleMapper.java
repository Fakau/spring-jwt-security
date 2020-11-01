package com.engine.fakau.springjwtsecurity.sercice.mapper;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.domaine.Role;
import com.engine.fakau.springjwtsecurity.sercice.dto.RoleDTO;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper implements IMapper<Role, RoleDTO> {
    @Override
    public Role toEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setCreationUser(roleDTO.getCreationUser());
        role.setCreationDate(roleDTO.getCreationDate());
        role.setUpdateUser(roleDTO.getUpdateUser());
        role.setNomRole(roleDTO.getNomRole());
        return role;
    }

    @Override
    public RoleDTO toDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setCreationUser(role.getCreationUser());
        roleDTO.setCreationDate(role.getCreationDate());
        roleDTO.setUpdateUser(role.getUpdateUser());
        roleDTO.setNomRole(role.getNomRole());
        return roleDTO;
    }
}
