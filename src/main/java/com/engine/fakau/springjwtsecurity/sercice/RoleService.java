package com.engine.fakau.springjwtsecurity.sercice;
import com.engine.fakau.springjwtsecurity.domaine.Role;

import java.util.List;

public interface RoleService {
    public Role create(Role role);
    public Role update(Role role);
    public void delete(final Long id);
    public List<Role> getAll();
}
