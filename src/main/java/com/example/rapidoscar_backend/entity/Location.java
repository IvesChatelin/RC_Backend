package com.example.rapidoscar_backend.entity;

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
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

    @Column(name = "datedepart")
    private LocalDate datedepart;

    @Column(name = "dateretour")
    private LocalDate dateretour;

    @Column(name = "heuredepart")
    private LocalTime heuredepart;

    @Column(name = "heureretour")
    private LocalTime heureretour;

    @Column(name = "nbrejour")
    private Integer nbrejour;

    @Column(name = "prix")
    private Integer prix;

    @Column(name = "ville", length = 50)
    private String ville;

}