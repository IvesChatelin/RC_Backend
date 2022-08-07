package com.example.rapidoscar_backend.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AutorisationId implements Serializable {
    private static final long serialVersionUID = -6875235078781736603L;
    @Column(name = "iduser", nullable = false)
    private Integer iduser;

    @Column(name = "idrole", nullable = false)
    private Integer idrole;

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIdrole() {
        return idrole;
    }

    public void setIdrole(Integer idrole) {
        this.idrole = idrole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AutorisationId entity = (AutorisationId) o;
        return Objects.equals(this.iduser, entity.iduser) &&
                Objects.equals(this.idrole, entity.idrole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, idrole);
    }

}