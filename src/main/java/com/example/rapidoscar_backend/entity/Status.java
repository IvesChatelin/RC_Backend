package com.example.rapidoscar_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "status")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status implements Serializable {
    @Id
    @Column(name = "idstatus", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idlocation", nullable = false)
    private Location idlocation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idvehicule", nullable = false)
    private Vehicule idvehicule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(Location idlocation) {
        this.idlocation = idlocation;
    }

    public Vehicule getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(Vehicule idvehicule) {
        this.idvehicule = idvehicule;
    }

}