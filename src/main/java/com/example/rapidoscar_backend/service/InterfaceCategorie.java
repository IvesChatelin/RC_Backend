package com.example.rapidoscar_backend.service;

import com.example.rapidoscar_backend.entity.Categories;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface InterfaceCategorie {
    Categories save(Categories categories);
    void delete(Integer id);
    Categories update(Categories categories, Integer id) throws ChangeSetPersister.NotFoundException;
    List<Categories> allCat();
    Categories getByid();
    Categories getByNom();
}
