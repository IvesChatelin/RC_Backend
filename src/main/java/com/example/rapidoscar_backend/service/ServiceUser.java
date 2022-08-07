package com.example.rapidoscar_backend.service;


import com.example.rapidoscar_backend.entity.User;
import com.example.rapidoscar_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser implements InterfaceUser {

    @Autowired
    UserRepository userRepository;

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
            User usermod = userfinded.get();
            if(user.getNom() != null){
                usermod.setNom(user.getNom());
            }else if(user.getPrenom() != null){
                usermod.setPrenom(user.getPrenom());
            }else if(user.getEmail() != null){
                usermod.setEmail(user.getEmail());
            }else if(user.getUsername() != null){
                usermod.setUsername(user.getUsername());
            }else if (user.getTelephone() != null){
                usermod.setTelephone(user.getTelephone());
            }else if (user.getPassword() != null){
                usermod.setPassword(user.getPassword());
            }
            return userRepository.save(usermod);
        }else {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
