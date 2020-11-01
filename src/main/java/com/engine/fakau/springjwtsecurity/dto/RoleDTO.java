package com.engine.fakau.springjwtsecurity.dto;

public class RoleDTO  extends AbstractAuditDomaineDTO{
    // @NotNull(message = "NomRole must not be null")
    private String nomRole;

    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "nomRole='" + nomRole + '\'' +
                ", id=" + id +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", creationUser='" + creationUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
