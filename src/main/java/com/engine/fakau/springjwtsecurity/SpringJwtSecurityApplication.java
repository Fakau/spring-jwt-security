package com.engine.fakau.springjwtsecurity;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringJwtSecurityApplication {
	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJwtSecurityApplication.class, args);
	}

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
