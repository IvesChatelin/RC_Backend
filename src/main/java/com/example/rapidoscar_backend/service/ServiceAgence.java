package com.example.rapidoscar_backend.service;


import com.example.rapidoscar_backend.entity.Agence;
import com.example.rapidoscar_backend.repository.AgenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAgence implements InterfaceAgence {

    private AgenceRepository agenceRepository;

    @Override
    public Agence save(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void delete(Integer id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public Agence update(Agence agence, Integer id) {
        Optional<Agence> agencefinded = agenceRepository.findById(id);
        if(agencefinded.isPresent()){
            Agence agencemod = agenceRepository.save(agence);
            return agencemod;
        }else {
            return null;
        }
    }

    @Override
    public List<Agence> getAll() {
        return agenceRepository.findAll();
    }
}
