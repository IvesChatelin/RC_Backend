package com.example.rapidoscar_backend.controller;


import com.example.rapidoscar_backend.entity.Role;
import com.example.rapidoscar_backend.entity.User;
import com.example.rapidoscar_backend.payload.*;
import com.example.rapidoscar_backend.repository.RoleRepository;
import com.example.rapidoscar_backend.repository.UserRepository;
import com.example.rapidoscar_backend.security.JwtProvider;
import com.example.rapidoscar_backend.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody() LoginForm loginForm){
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getUsername(),
                        loginForm.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtProvider.generateJwtToken(auth);
        //return ResponseEntity.ok(new JwtResponce(jwt));
        UserPrincipale userPrincipale = (UserPrincipale) auth.getPrincipal();
        List<String> roles = userPrincipale.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponce(jwt, userPrincipale.getUsername(), userPrincipale.getEmail(), userPrincipale.getId(),roles));
    }

    @GetMapping("/logout")
    public void logout(){

    }
}
