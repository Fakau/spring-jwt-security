package com.engine.fakau.springjwtsecurity.config;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.domaine.Role;
import com.engine.fakau.springjwtsecurity.domaine.enumeation.NomRole;
import com.engine.fakau.springjwtsecurity.repository.ContactRepository;
import com.engine.fakau.springjwtsecurity.repository.RoleRepository;
import com.engine.fakau.springjwtsecurity.repository.UserRepository;
import com.engine.fakau.springjwtsecurity.sercice.RoleService;
import com.engine.fakau.springjwtsecurity.sercice.dto.RoleDTO;
import com.engine.fakau.springjwtsecurity.sercice.dto.UserDTO;
import com.engine.fakau.springjwtsecurity.sercice.serviceImpl.RoleServiceImpl;
import com.engine.fakau.springjwtsecurity.sercice.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class BeanConfigiration {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private RoleServiceImpl roleService;
    @Autowired
    private UserServiceImpl userService;


    @Bean
    public void addDefaultContact(){
        Contact c=new Contact();
        c.setCreationDate(LocalDateTime.now());
        c.setCreationUser("System");
        c.setNom("Kafka");
        c.setTelephone("+509 3792-4232");
        c.setEmail("laurentkafka123@gmail.com");
        System.out.println(contactRepository.save(c));
        c=new Contact();
        c.setCreationDate(LocalDateTime.now());
        c.setCreationUser("System");
        c.setNom("Clerel");
        c.setTelephone("+509 3129-9933");
        c.setEmail("laurentclerel123@gmail.com");
        System.out.println(contactRepository.save(c));
    }
    @Bean
    public void addDefaultUser(){
        RoleDTO role =new RoleDTO();
        role.setCreationDate(LocalDateTime.now());
        role.setCreationUser("System");
        role.setNomRole(NomRole.SYSTEM);
        UserDTO user =new UserDTO();
        user.setRoleDTOs(Arrays.asList(roleService.create(role)));
        user.setLogin("admin");
        user.setPassword("admin");
        user.setEmail("admin@localhost");
        user.setEnabled(true);
        user.setCreationDate(LocalDateTime.now());
        user.setCreationUser("System");
        userService.create(user);
    }
}
