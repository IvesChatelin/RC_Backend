package com.example.rapidoscar_backend.controller;

import com.example.rapidoscar_backend.entity.Categories;
import com.example.rapidoscar_backend.service.ServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categorie")
public class CatController {

    @Autowired
    ServiceCategorie serviceCategorie;

    @PostMapping("/add")
    public ResponseEntity<Categories> addCat(@RequestBody() Categories categories){
        try{
            Categories categoriesSaved = serviceCategorie.save(categories);
            return ResponseEntity.ok().body(categoriesSaved);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(path = "/delete", params = "id")
    public ResponseEntity<?> deleteCat(@RequestParam Integer id){
        try{
            serviceCategorie.delete(id);
            return ResponseEntity.ok().body("Utilisateur supprimé : " +id);
        }catch (Exception e){
            return ResponseEntity.ok().body("utilisateur non  supprimé : -> {}"+e.getMessage());
        }
    }

    @PutMapping(path = "/update", params = "id")
    //@PreAuthorize("hasRole('ADMIN','AGENCE')")
    public ResponseEntity<Categories> updateCat(@RequestBody() Categories categories, @RequestParam Integer id){
        try{
            Categories catUpdated = serviceCategorie.update(categories,id);
            return ResponseEntity.ok().body(catUpdated);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
}
