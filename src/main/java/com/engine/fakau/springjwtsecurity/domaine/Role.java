package com.engine.fakau.springjwtsecurity.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends  AbstractAuditDomaine{

    @Column(name = "nom_role", nullable = false)
    private String nomRole;

    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }
}
