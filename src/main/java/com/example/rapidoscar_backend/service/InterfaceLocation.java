package com.example.rapidoscar_backend.service;


import com.example.rapidoscar_backend.entity.Location;

import java.util.List;

public interface InterfaceLocation {

    Location save(Location location);

    Location update(Location location, Integer id);

    void delete(Integer id);

    List<Location> getAll();
}
