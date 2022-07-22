package com.example.rapidoscar_backend.service;


import com.example.rapidoscar_backend.entity.Vehicule;
import com.example.rapidoscar_backend.repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceVehicule implements InterfaceVehicule {

    private VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule save(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void delete(Integer id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule update(Vehicule vehicule, Integer id) {
        Optional<Vehicule> vehiculefinded = vehiculeRepository.findById(id);
        if(vehiculefinded.isPresent()){
            Vehicule vehiculemod = vehiculeRepository.save(vehicule);
            return vehiculemod;
        }else {
            return null;
        }
    }

    @Override
    public List<Vehicule> getAll() {
        return vehiculeRepository.findAll();
    }
}
