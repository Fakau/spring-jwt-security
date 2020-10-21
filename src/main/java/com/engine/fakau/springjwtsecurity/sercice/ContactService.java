package com.engine.fakau.springjwtsecurity.sercice;

import com.engine.fakau.springjwtsecurity.domaine.Contact;

import java.util.List;

public interface ContactService {
    public Contact create(Contact contact);
    public Contact update(Contact contact);
    public void delete(final Long id);
    public List<Contact> getAll();
}
