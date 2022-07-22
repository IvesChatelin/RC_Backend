package com.example.rapidoscar_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username", "email"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @Column(name = "iduser", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "email", length = 54)
    @NaturalId
    private String email;

    @Column(name = "telephone")
    private Integer telephone;

    @Column(name = "password", length = 80)
    private String password;

    @Column(name = "numcni")
    private Integer numcni;

    @Column(name = "username", length = 50)
    @NaturalId
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "iduser"),
    inverseJoinColumns = @JoinColumn(name = "idrole"))
    private  Set<Role> roles = new HashSet<>();

}