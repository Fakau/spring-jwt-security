package com.engine.fakau.springjwtsecurity.sercice.dto;

import com.engine.fakau.springjwtsecurity.domaine.enumeation.NomRole;

import javax.validation.constraints.NotNull;

public class RoleDTO  extends AbstractAuditDomaineDTO{
    @NotNull(message = "NomRole must not be null")
    private NomRole nomRole;

    public NomRole getNomRole() {
        return nomRole;
    }

    public void setNomRole(NomRole nomRole) {
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
