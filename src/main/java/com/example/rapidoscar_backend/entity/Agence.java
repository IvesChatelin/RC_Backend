package com.example.rapidoscar_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

@Entity
@Table(name = "agence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idagence", nullable = false)
    private Integer id;

    @Column(name = "nomagence", length = 50)
    private String nomagence;

    @Column(name = "adresse", length = 50)
    private String adresse;

    @Column(name = "telephone")
    private Integer telephone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "login", length = 20)
    private String login;

    @Column(name = "pwd", length = 80)
    private String pwd;

}