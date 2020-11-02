package com.engine.fakau.springjwtsecurity.domaine;

import com.engine.fakau.springjwtsecurity.domaine.enumeation.NomRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends  AbstractAuditDomaine{

    @Column(name = "nom_role", nullable = false)
    @Enumerated
    private NomRole nomRole;

    public NomRole getNomRole() {
        return nomRole;
    }

    public void setNomRole(NomRole nomRole) {
        this.nomRole = nomRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "nomRole='" + nomRole + '\'' +
                ", id=" + id +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", creationUser='" + creationUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
