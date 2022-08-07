package com.example.rapidoscar_backend.service;

import com.example.rapidoscar_backend.entity.Categories;
import com.example.rapidoscar_backend.entity.Images;
import com.example.rapidoscar_backend.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategorie implements InterfaceCategorie{

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categories save(Categories categories) {
        return categorieRepository.save(categories);
    }

    @Override
    public void delete(Integer id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categories update(Categories categories, Integer id) throws ChangeSetPersister.NotFoundException {
        Optional<Categories> catExist = categorieRepository.findById(id);
        if (catExist.isPresent()){
            Categories catmod = catExist.get();
            if (categories.getNom_cat() != null){
                catmod.setNom_cat(categories.getNom_cat());
            }else if(categories.getIdimage() != null){
                Images images = new Images();
                images.setId(categories.getIdimage().getId());
                catmod.setIdimage(images);
            }
            return categorieRepository.save(catmod);
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @Override
    public List<Categories> allCat() {
        return null;
    }

    @Override
    public Categories getByid() {
        return null;
    }

    @Override
    public Categories getByNom() {
        return null;
    }
}
