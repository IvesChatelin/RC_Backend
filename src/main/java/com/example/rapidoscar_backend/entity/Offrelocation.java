package com.example.rapidoscar_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "offrelocation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offrelocation implements Serializable {
    @Id
    @Column(name = "idoffre", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

    @Column(name = "dateoffre")
    private LocalDate dateoffre;

    @Column(name = "datefin")
    private LocalDate datefin;

    @Column(name = "libelle", length = 254)
    private String libelle;

    @Column(name = "reduction")
    private Integer reduction;

    @Column(name = "surnbrejour")
    private Integer surnbrejour;

    @Column(name = "surprix")
    private Integer surprix;

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

    public LocalDate getDateoffre() {
        return dateoffre;
    }

    public void setDateoffre(LocalDate dateoffre) {
        this.dateoffre = dateoffre;
    }

    public LocalDate getDatefin() {
        return datefin;
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getReduction() {
        return reduction;
    }

    public void setReduction(Integer reduction) {
        this.reduction = reduction;
    }

    public Integer getSurnbrejour() {
        return surnbrejour;
    }

    public void setSurnbrejour(Integer surnbrejour) {
        this.surnbrejour = surnbrejour;
    }

    public Integer getSurprix() {
        return surprix;
    }

    public void setSurprix(Integer surprix) {
        this.surprix = surprix;
    }

}