package com.example.rapidoscar_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Images implements Serializable {

    @Id
    @Column(name = "idimage", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "nom", length = 254)
    private String nom;

    @Column(name = "type", length = 254)
    private String type;

    public Images(byte[] image, String nom, String type) {
        this.image = image;
        this.nom = nom;
        this.type = type;
    }

    @JsonIgnore
    public byte[] getImage() {
        return image;
    }
}
