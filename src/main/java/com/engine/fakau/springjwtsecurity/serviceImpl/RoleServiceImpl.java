package com.engine.fakau.springjwtsecurity.serviceImpl;

import com.engine.fakau.springjwtsecurity.domaine.Role;
import com.engine.fakau.springjwtsecurity.exception.BadRequestException;
import com.engine.fakau.springjwtsecurity.repository.RoleRepository;
import com.engine.fakau.springjwtsecurity.sercice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role create(Role role){
        if(role.getId() != null){
            throw new BadRequestException("Cannot create Role with id != null");
        }
        return roleRepository.save(role);
    }
    public Role update(Role role){
        if(role.getId() == null){
            throw new BadRequestException("Cannot update Role with id null");
        }
        return roleRepository.save(role);
    }
    public void delete(final Long id){
        if(id == null){
            throw new IllegalArgumentException("id must not be null");
        }
        roleRepository.deleteById(id);
    }
    public List<Role> getAll(){
        return roleRepository.findAll();
    }
}
