package com.engine.fakau.springjwtsecurity.resource;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.sercice.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactResource {
    private final ContactService contactService;

    public ContactResource(ContactService contactService){
        this.contactService = contactService;
    }
    @PostMapping("/contact")
    public Contact create(@RequestBody Contact contact){
        return contactService.create(contact);
    }
    @PutMapping("/contact")
    public Contact update(@RequestBody Contact contact){
        return contactService.update(contact);
    }
    @GetMapping("/contact")
    public List<Contact> getAll(){
        return contactService.getAll();
    }
    @DeleteMapping("/contact")
    public void delete(final Long id){
        contactService.delete(id);
    }


}
