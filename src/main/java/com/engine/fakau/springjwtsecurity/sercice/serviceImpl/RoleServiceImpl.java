package com.engine.fakau.springjwtsecurity.sercice.serviceImpl;

import com.engine.fakau.springjwtsecurity.domaine.Role;
import com.engine.fakau.springjwtsecurity.exception.BadRequestException;
import com.engine.fakau.springjwtsecurity.repository.RoleRepository;
import com.engine.fakau.springjwtsecurity.sercice.RoleService;
import com.engine.fakau.springjwtsecurity.sercice.dto.RoleDTO;
import com.engine.fakau.springjwtsecurity.sercice.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;

    public RoleDTO create(RoleDTO roleDTO){
        Role role = roleMapper.toEntity(roleDTO);
        if(role.getId() != null){
            throw new BadRequestException("Cannot create Role with id != null");
        }
        return roleMapper.toDTO(roleRepository.save(role));
    }
    public RoleDTO update(RoleDTO roleDTO){
        Role role = roleMapper.toEntity(roleDTO);
        if(role.getId() == null){
            throw new BadRequestException("Cannot update Role with id null");
        }
        return roleMapper.toDTO(roleRepository.save(role));
    }
    public void delete(final Long id){
        if(id == null){
            throw new IllegalArgumentException("id must not be null");
        }
        roleRepository.deleteById(id);
    }
    public List<RoleDTO> getAll(){
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDTO)
                .collect(Collectors.toList());
    }
}
