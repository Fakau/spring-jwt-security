package com.engine.fakau.springjwtsecurity.sercice;
import com.engine.fakau.springjwtsecurity.domaine.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User create(User user);
    public User update(User user);
    public void delete(final Long id);
    public List<User> getAll();
    public Optional<User> getUserByLogin(String login);
}
