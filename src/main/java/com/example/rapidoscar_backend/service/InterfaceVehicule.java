package com.example.rapidoscar_backend.service;



import com.example.rapidoscar_backend.entity.Vehicule;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface InterfaceVehicule {

    Vehicule save(Vehicule vehicule);

    void delete(Integer id);

    Vehicule update(Vehicule vehicule, Integer id);

    List<Vehicule> getAll();
}
