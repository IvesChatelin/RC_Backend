package com.example.rapidoscar_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locationvehicule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locationvehicule implements Serializable {
    @Id
    @Column(name = "idlocveh", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idvehicule", nullable = false)
    private Vehicule idvehicule;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idlocation", nullable = false)
    private Location idlocation;
}