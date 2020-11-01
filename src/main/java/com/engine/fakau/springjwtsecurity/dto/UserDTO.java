package com.engine.fakau.springjwtsecurity.dto;

import com.engine.fakau.springjwtsecurity.domaine.AbstractAuditDomaine;
import com.engine.fakau.springjwtsecurity.domaine.Role;
import java.util.ArrayList;
import java.util.List;

public class UserDTO extends AbstractAuditDomaineDTO {
    @NotNull(message = "Password must not be null")
    private  String login;
    @NotNull(message = "Password must not be null")
    @NotBlank(message = "Password must not be blank")
    @Email(message = "Invalid email format")
    private  String email;
    private List<Role> roles = new ArrayList<>();

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", roles=" + roles +
                ", id=" + id +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", creationUser='" + creationUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
