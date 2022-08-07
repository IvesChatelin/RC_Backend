package com.example.rapidoscar_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "marque")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marque implements Serializable {

    @Id
    @Column(name = "idmarque", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomMarque", length = 254)
    private String nom_marque;

}
