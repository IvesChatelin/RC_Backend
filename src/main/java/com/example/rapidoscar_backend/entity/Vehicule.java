package com.example.rapidoscar_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule implements Serializable {
    @Id
    @Column(name = "idvehicule", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idagence", nullable = false)
    private Agence idagence;

    @Column(name = "nomvehicule", length = 50)
    private String nomvehicule;

    @Column(name = "marque", length = 50)
    private String marque;

    @Column(name = "categorie", length = 50)
    private String categorie;

    @Column(name = "transmission", length = 50)
    private String transmission;

    @Column(name = "porte")
    private Integer porte;

    @Column(name = "siege")
    private Integer siege;

    @Column(name = "kilometrage", length = 50)
    private String kilometrage;

    @Column(name = "climatisation", length = 50)
    private String climatisation;

    @Column(name = "ageconducteur")
    private Integer ageconducteur;

    @Column(name = "prixjour")
    private Integer prixjour;

}