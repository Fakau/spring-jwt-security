package com.engine.fakau.springjwtsecurity.dto;

import com.engine.fakau.springjwtsecurity.domaine.AbstractAuditDomaine;
import com.engine.fakau.springjwtsecurity.domaine.Role;
import java.util.ArrayList;
import java.util.List;

public class UserDTO extends AbstractAuditDomaine {
    private  String login;
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
