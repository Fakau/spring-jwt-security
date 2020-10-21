package com.engine.fakau.springjwtsecurity.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact extends  AbstractAuditDomaine{
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "telephone",nullable = false)
    private String telephone;
    @Column(name = "email",nullable = false)
    private String email;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", creationUser='" + creationUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
