package com.engine.fakau.springjwtsecurity.sercice;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    public ContactDTO create(ContactDTO contactDTO);
    public ContactDTO update(ContactDTO contactDTO);
    public void delete(final Long id);
    public List<ContactDTO> getAll();
}
