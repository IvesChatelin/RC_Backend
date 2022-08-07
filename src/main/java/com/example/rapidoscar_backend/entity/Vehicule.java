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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idmarque", nullable = false)
    private Marque idmarque;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcategorie", nullable = false)
    private Categories idcategorie;

    @Column(name = "nomvehicule", length = 254)
    private String nomvehicule;

    @Column(name = "transmission", length = 254)
    private String transmission;

    @Column(name = "porte")
    private Integer porte;

    @Column(name = "siege")
    private Integer siege;

    @Column(name = "kilometrage", length = 254)
    private String kilometrage;

    @Column(name = "climatisation", length = 254)
    private String climatisation;

    @Column(name = "ageconducteur")
    private Integer ageconducteur;

    @Column(name = "tarif")
    private Integer tarif;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public String getNomvehicule() {
        return nomvehicule;
    }

    public void setNomvehicule(String nomvehicule) {
        this.nomvehicule = nomvehicule;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getPorte() {
        return porte;
    }

    public void setPorte(Integer porte) {
        this.porte = porte;
    }

    public Integer getSiege() {
        return siege;
    }

    public void setSiege(Integer siege) {
        this.siege = siege;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getClimatisation() {
        return climatisation;
    }

    public void setClimatisation(String climatisation) {
        this.climatisation = climatisation;
    }

    public Integer getAgeconducteur() {
        return ageconducteur;
    }

    public void setAgeconducteur(Integer ageconducteur) {
        this.ageconducteur = ageconducteur;
    }


}