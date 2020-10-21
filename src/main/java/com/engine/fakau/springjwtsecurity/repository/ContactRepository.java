package com.engine.fakau.springjwtsecurity.repository;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
