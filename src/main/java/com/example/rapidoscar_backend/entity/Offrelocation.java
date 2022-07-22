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
@NoArgsConstructor
@AllArgsConstructor
public class Offrelocation implements Serializable {
    @Id
    @Column(name = "idoffre", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idagence", nullable = false)
    private Agence idagence;

    @Column(name = "dateoffre")
    private LocalDate dateoffre;

    @Column(name = "datefin")
    private LocalDate datefin;

    @Column(name = "libelle", length = 254)
    private String libelle;

}