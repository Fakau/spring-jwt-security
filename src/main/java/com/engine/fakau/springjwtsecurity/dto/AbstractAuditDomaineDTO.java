package com.engine.fakau.springjwtsecurity.dto;
import java.io.Serializable;
import java.time.LocalDateTime;

public class AbstractAuditDomaineDTO implements Serializable {
    protected Long id;
    protected LocalDateTime creationDate;
    protected LocalDateTime updateDate;
    protected String creationUser;
    protected String updateUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "AbstractAuditDomaineDTO{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", creationUser='" + creationUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}