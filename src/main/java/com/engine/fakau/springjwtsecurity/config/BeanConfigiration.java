package com.engine.fakau.springjwtsecurity.config;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BeanConfigiration {
    @Autowired
    private ContactRepository contactRepository;

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
}
