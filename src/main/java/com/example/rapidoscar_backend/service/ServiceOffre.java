package com.example.rapidoscar_backend.service;


import com.example.rapidoscar_backend.entity.Offrelocation;
import com.example.rapidoscar_backend.repository.OffreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOffre implements InterfaceOffre {

    private OffreRepository offreRepository;

    @Override
    public Offrelocation save(Offrelocation offre) {
        return offreRepository.save(offre);
    }

    @Override
    public void delete(Integer id) {
        offreRepository.deleteById(id);
    }

    @Override
    public Offrelocation update(Offrelocation offre, Integer id) {
        Optional<Offrelocation> offrefinded = offreRepository.findById(id);
        if(offrefinded.isPresent()){
            Offrelocation offremod = offreRepository.save(offre);
            return offremod;
        }else {
            return null;
        }
    }

    @Override
    public List<Offrelocation> getAll() {
        return offreRepository.findAll();
    }
}
