package com.example.rapidoscar_backend.service;


import com.example.rapidoscar_backend.entity.Location;
import com.example.rapidoscar_backend.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLocation implements InterfaceLocation {

    private LocationRepository locationRepository;

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location update(Location location, Integer id) {
        Optional<Location> locationfinded = locationRepository.findById(id);
        if(locationfinded.isPresent()){
            Location locationmod = locationRepository.save(location);
            return locationmod;
        }else {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }
}
