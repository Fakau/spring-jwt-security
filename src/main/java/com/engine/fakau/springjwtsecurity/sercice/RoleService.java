package com.engine.fakau.springjwtsecurity.sercice;
import com.engine.fakau.springjwtsecurity.domaine.Role;
import com.engine.fakau.springjwtsecurity.sercice.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    public RoleDTO create(RoleDTO role);
    public RoleDTO update(RoleDTO role);
    public void delete(final Long id);
    public List<RoleDTO> getAll();
}
