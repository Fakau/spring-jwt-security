package com.engine.fakau.springjwtsecurity.repository;

import com.engine.fakau.springjwtsecurity.domaine.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findOneByLogin(String login);
  Optional<User> findOneByEmail(String email);
}
