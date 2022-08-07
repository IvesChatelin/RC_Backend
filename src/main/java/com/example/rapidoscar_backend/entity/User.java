package com.example.rapidoscar_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"User\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @Column(name = "iduser", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", length = 254)
    private String nom;

    @Column(name = "prenom", length = 254)
    private String prenom;

    @Column(name = "email", length = 254)
    private String email;

    @Column(name = "telephone")
    private Integer telephone;

    @Column(name = "password", length = 254)
    private String password;

    @Column(name = "numcni")
    private Integer numcni;

    @Column(name = "username", length = 254)
    private String username;

    @Column(name = "ville", length = 254)
    private String ville;

    @Column(name = "adresse", length = 254)
    private String adresse;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "autorisation",
            joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = "idrole"))
    private Set<Role> role = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNumcni() {
        return numcni;
    }

    public void setNumcni(Integer numcni) {
        this.numcni = numcni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

}