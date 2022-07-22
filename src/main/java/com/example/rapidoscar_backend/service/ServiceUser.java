package com.example.rapidoscar_backend.service;


import com.example.rapidoscar_backend.entity.User;
import com.example.rapidoscar_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser implements InterfaceUser {

    private UserRepository userRepository;

    public ServiceUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user, Integer id) {
        Optional<User> userfinded = userRepository.findById(id);
        if(userfinded.isPresent()){
            User usermod = userRepository.save(user);
            return usermod;
        }else {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
