package com.example.rapidoscar_backend.service;



import com.example.rapidoscar_backend.entity.Agence;

import java.util.List;

public interface InterfaceAgence {

    Agence save(Agence agence);

    void delete(Integer id);

    Agence update(Agence agence, Integer id);

    List<Agence> getAll();
}
