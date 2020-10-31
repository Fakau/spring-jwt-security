package com.engine.fakau.springjwtsecurity.sercice.serviceImpl;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.exception.BadRequestException;
import com.engine.fakau.springjwtsecurity.repository.ContactRepository;
import com.engine.fakau.springjwtsecurity.sercice.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Contact create(Contact contact){
        if(contact.getId() != null){
           throw new BadRequestException("Cannot create contact with id != null");
        }
        return contactRepository.save(contact);
    }
    public Contact update(Contact contact){
        if(contact.getId() == null){
           throw new BadRequestException("Cannot update contact with id null");
        }
        return contactRepository.save(contact);
    }
    public void delete(final Long id){
        if(id == null){
           throw new IllegalArgumentException("id must not be null");
        }
        contactRepository.deleteById(id);
    }
    public List<Contact> getAll(){
        return contactRepository.findAll();
    }

}
