package com.example.rapidoscar_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "autorisation")
public class Autorisation {
    @EmbeddedId
    private AutorisationId id;

    @MapsId("iduser")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

    @MapsId("idrole")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idrole", nullable = false)
    private Role idrole;

    public AutorisationId getId() {
        return id;
    }

    public void setId(AutorisationId id) {
        this.id = id;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public Role getIdrole() {
        return idrole;
    }

    public void setIdrole(Role idrole) {
        this.idrole = idrole;
    }

}