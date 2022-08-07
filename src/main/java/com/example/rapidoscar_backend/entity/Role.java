package com.example.rapidoscar_backend.entity;

import com.example.rapidoscar_backend.payload.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    @Id
    @Column(name = "idrole", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", length = 254)
    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName nom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleName getNom() {
        return nom;
    }

    public void setNom(RoleName nom) {
        this.nom = nom;
    }

}