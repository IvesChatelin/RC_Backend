package com.example.rapidoscar_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicule")
public class VehiculeController {

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return null;
    }

}
