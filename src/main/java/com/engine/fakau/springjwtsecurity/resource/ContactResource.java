package com.engine.fakau.springjwtsecurity.resource;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.dto.ContactDTO;
import com.engine.fakau.springjwtsecurity.sercice.ContactService;
import com.engine.fakau.springjwtsecurity.sercice.serviceImpl.ContactServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactResource {
    private final ContactServiceImpl contactService;

    public ContactResource(ContactServiceImpl contactService){
        this.contactService = contactService;
    }
    @PostMapping("/contact")
    public ContactDTO create(@RequestBody ContactDTO contact){
        return contactService.create(contact);
    }
    @PutMapping("/contact")
    public ContactDTO update(@RequestBody ContactDTO contact){
        return contactService.update(contact);
    }
    @GetMapping("/contact")
    public List<ContactDTO> getAll(){
        return contactService.getAll();
    }
    @DeleteMapping("/contact")
    public void delete(final Long id){
        contactService.delete(id);
    }


}
