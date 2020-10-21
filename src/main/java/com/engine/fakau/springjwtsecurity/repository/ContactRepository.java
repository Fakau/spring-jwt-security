package com.engine.fakau.springjwtsecurity.repository;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
