package com.example.rapidoscar_backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location implements Serializable {
    @Id
    @Column(name = "idlocation", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

    @Column(name = "datedepart")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonIgnore
    private LocalDate datedepart;

    @Column(name = "dateretour")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonIgnore
    private LocalDate dateretour;

    @Column(name = "heuredepart")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @JsonIgnore
    private LocalTime heuredepart;

    @Column(name = "heureretour")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @JsonIgnore
    private LocalTime heureretour;

    @Column(name = "nbrejour")
    private Integer nbrejour;

    @Column(name = "prix")
    private Integer prix;

    @Column(name = "ville", length = 254)
    private String ville;

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

    public LocalDate getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(LocalDate datedepart) {
        this.datedepart = datedepart;
    }

    public LocalDate getDateretour() {
        return dateretour;
    }

    public void setDateretour(LocalDate dateretour) {
        this.dateretour = dateretour;
    }

    public LocalTime getHeuredepart() {
        return heuredepart;
    }

    public void setHeuredepart(LocalTime heuredepart) {
        this.heuredepart = heuredepart;
    }

    public LocalTime getHeureretour() {
        return heureretour;
    }

    public void setHeureretour(LocalTime heureretour) {
        this.heureretour = heureretour;
    }

    public Integer getNbrejour() {
        return nbrejour;
    }

    public void setNbrejour(Integer nbrejour) {
        this.nbrejour = nbrejour;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}