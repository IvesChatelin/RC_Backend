package com.example.rapidoscar_backend.security;

import com.example.rapidoscar_backend.payload.UserPrincipe;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.rapidoscar_backend.entity.User;
import com.example.rapidoscar_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            User user = userRepository.findByUsername(username);
            return UserPrincipe.Detail(user);
        }catch (UsernameNotFoundException e){
            e.getMessage();
            return null;
        }

    }
}
