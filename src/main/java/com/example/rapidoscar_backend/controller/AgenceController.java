package com.example.rapidoscar_backend.controller;

import com.example.rapidoscar_backend.entity.Agence;
import com.example.rapidoscar_backend.service.ServiceAgence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agence")
public class AgenceController {

    private ServiceAgence serviceAgence;

    @Autowired
    PasswordEncoder encoder;

    @RequestMapping("/")
    public ResponseEntity<List<Agence>> getAllAgence(){
        try{
            return  new ResponseEntity<>(serviceAgence.getAll(), HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
