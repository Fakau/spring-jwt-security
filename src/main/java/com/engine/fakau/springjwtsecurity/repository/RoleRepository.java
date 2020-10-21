package com.engine.fakau.springjwtsecurity.repository;

import com.engine.fakau.springjwtsecurity.domaine.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
   Optional<Role> findByNomRole(String nomRole);
}
