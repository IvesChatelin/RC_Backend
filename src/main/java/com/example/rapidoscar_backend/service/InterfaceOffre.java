package com.example.rapidoscar_backend.service;



import com.example.rapidoscar_backend.entity.Offrelocation;

import java.util.List;

public interface InterfaceOffre {

    Offrelocation save(Offrelocation offre);

    void delete(Integer id);

    Offrelocation update(Offrelocation offre, Integer id);

    List<Offrelocation> getAll();
}
