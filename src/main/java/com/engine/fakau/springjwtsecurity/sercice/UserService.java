package com.engine.fakau.springjwtsecurity.sercice;
import com.engine.fakau.springjwtsecurity.sercice.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserDTO create(UserDTO user);
    public UserDTO update(UserDTO user);
    public void delete(final Long id);
    public List<UserDTO> getAll();
    Optional<UserDTO> findOneByLogin(String login);
}
