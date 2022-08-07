package com.example.rapidoscar_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "agence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agence implements Serializable {
    @Id
    @Column(name = "idagence", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

    @Column(name = "nomagence", length = 50)
    private String nomagence;

    @Column(name = "adresse", length = 50)
    private String adresse;

    @Column(name = "ville", length = 50)
    private String ville;

    @Column(name = "telephone")
    private Integer telephone;

    @Column(name = "login", length = 254)
    private String login;

    @Column(name = "password", length = 254)
    private String password;

    @Column(name = "email", length = 254)
    private String email;

}