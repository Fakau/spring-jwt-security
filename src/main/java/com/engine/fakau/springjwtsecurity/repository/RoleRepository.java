package com.engine.fakau.springjwtsecurity.repository;

import com.engine.fakau.springjwtsecurity.domaine.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
