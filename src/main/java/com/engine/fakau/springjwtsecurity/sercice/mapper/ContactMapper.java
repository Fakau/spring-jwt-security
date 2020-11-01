package com.engine.fakau.springjwtsecurity.sercice.mapper;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.dto.ContactDTO;
import org.springframework.stereotype.Service;

@Service
public class ContactMapper implements IMapper<Contact, ContactDTO>{
    @Override
    public Contact toEntity(ContactDTO contactDTO) {
        return null;
    }

    @Override
    public ContactDTO toDTO(Contact contact) {
        return null;
    }
}
