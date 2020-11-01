package com.engine.fakau.springjwtsecurity.dto;

import javax.validation.constraints.Email;

public class ContactDTO extends AbstractAuditDomaineDTO {
    @NotNull(message = "Nom must not be null")
    private String nom;
    @NotNull(message = "Telephone must not be null")
    private String telephone;
    @NotNull(message = "Email must not be null")
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email invalid")
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
        return "ContactDTO{" +
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
