package com.engine.fakau.springjwtsecurity.dto;

import com.engine.fakau.springjwtsecurity.domaine.AbstractAuditDomaine;
import com.engine.fakau.springjwtsecurity.domaine.Role;
import java.util.ArrayList;
import java.util.List;

public class UserDTO extends AbstractAuditDomaineDTO {
    //@NotNull(message = "Password must not be null")
    private  String login;
    //@NotNull(message = "Password must not be null")
    //@NotBlank(message = "Password must not be blank")
    //@Email(message = "Invalid email format")
    private  String email;
    private boolean enabled;
    private List<Role> roles = new ArrayList<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", id=" + id +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", creationUser='" + creationUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
