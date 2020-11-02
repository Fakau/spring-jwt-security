package com.engine.fakau.springjwtsecurity.sercice.mapper;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.sercice.dto.ContactDTO;
import org.springframework.stereotype.Service;

@Service
public class ContactMapper implements IMapper<Contact, ContactDTO>{
    @Override
    public Contact toEntity(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setId(contactDTO.getId());
        contact.setCreationUser(contactDTO.getCreationUser());
        contact.setCreationDate(contactDTO.getCreationDate());
        contact.setUpdateUser(contactDTO.getUpdateUser());
        contact.setUpdateDate(contactDTO.getUpdateDate());
        contact.setEmail(contactDTO.getEmail());
        contact.setTelephone(contactDTO.getTelephone());
        contact.setNom(contactDTO.getNom());
        return contact;
    }

    @Override
    public ContactDTO toDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setCreationUser(contact.getCreationUser());
        contactDTO.setCreationDate(contact.getCreationDate());
        contactDTO.setUpdateUser(contact.getUpdateUser());
        contactDTO.setUpdateDate(contact.getUpdateDate());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setTelephone(contact.getTelephone());
        contactDTO.setNom(contact.getNom());
        return contactDTO;
    }
}
