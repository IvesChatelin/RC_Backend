package com.example.rapidoscar_backend.controller;


import com.example.rapidoscar_backend.entity.Role;
import com.example.rapidoscar_backend.entity.User;
import com.example.rapidoscar_backend.payload.JwtResponce;
import com.example.rapidoscar_backend.payload.LoginForm;
import com.example.rapidoscar_backend.payload.RoleName;
import com.example.rapidoscar_backend.payload.SingupForm;
import com.example.rapidoscar_backend.repository.RoleRepository;
import com.example.rapidoscar_backend.repository.UserRepository;
import com.example.rapidoscar_backend.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody() LoginForm loginForm){
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getUserName(),
                        loginForm.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtProvider.generateJwtToken(auth);
        return ResponseEntity.ok(new JwtResponce(jwt));
    }

    @GetMapping("/logout")
    public void logout(){

    }

    @PostMapping("/singup")
    public ResponseEntity<String> addUser( @RequestBody() SingupForm singupForm){
        try{
            if(userRepository.existsByUsername(singupForm.getUsername())){
                return new ResponseEntity<String>("l'utilisateur existe deja", HttpStatus.BAD_REQUEST);
            }
            if(userRepository.existsByEmail(singupForm.getEmail())){
                return new ResponseEntity<String>("l'utilisateur existe deja",HttpStatus.BAD_REQUEST);
            }
            User user = new User();
            Set<String> strRoles = singupForm.getRole();
            Set<Role> roles = new HashSet<>();
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        try{
                            Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN);
                            roles.add(adminRole);
                        }catch (Exception e){
                            e.getMessage();
                        }
                        break;

                    case "agence":
                        try{
                            Role agenceRole = roleRepository.findByName(RoleName.ROLE_AGENCE);
                            roles.add(agenceRole);
                        }catch (Exception e){
                            e.getMessage();
                        }
                        break;

                    case "user":
                        try{
                            Role userRole = roleRepository.findByName(RoleName.ROLE_USER);
                            roles.add(userRole);
                        }catch (Exception e){
                            e.getMessage();
                        }
                        break;

                }
            });
            user.setNom(singupForm.getNom());
            user.setPrenom(singupForm.getPrenom());
            user.setEmail(singupForm.getEmail());
            user.setTelephone(singupForm.getTelephone());
            user.setPassword(encoder.encode(singupForm.getPassword()));
            user.setNumcni(singupForm.getNumcni());
            user.setUsername(singupForm.getUsername());
            user.setRoles(roles);
            userRepository.save(user);
            return ResponseEntity.ok().body("Utilidateur ajouté avec success");
        }catch (Exception e){
            return  new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
