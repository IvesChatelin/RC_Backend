package com.example.rapidoscar_backend.controller;

import com.example.rapidoscar_backend.entity.Location;
import com.example.rapidoscar_backend.service.ServiceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    ServiceLocation serviceLocation;

    @PostMapping("/add")
    public ResponseEntity<Location> add(@RequestBody() Location location){
        try{
            Location loc = serviceLocation.save(location);
            return new ResponseEntity<>(loc, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
