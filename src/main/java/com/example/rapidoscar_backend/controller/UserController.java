package com.example.rapidoscar_backend.controller;

import com.example.rapidoscar_backend.entity.Role;
import com.example.rapidoscar_backend.entity.User;
import com.example.rapidoscar_backend.payload.RoleName;
import com.example.rapidoscar_backend.payload.SingupForm;
import com.example.rapidoscar_backend.repository.RoleRepository;
import com.example.rapidoscar_backend.repository.UserRepository;
import com.example.rapidoscar_backend.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    private ServiceUser serviceUser;

    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        try{
            return new ResponseEntity<>(serviceUser.getAll(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }
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
                            Role adminRole = roleRepository.findByNom(RoleName.ROLE_ADMIN);
                            roles.add(adminRole);
                        }catch (Exception e){
                            e.getMessage();
                        }
                        break;

                    case "agence":
                        try{
                            Role agenceRole = roleRepository.findByNom(RoleName.ROLE_AGENCE);
                            roles.add(agenceRole);
                        }catch (Exception e){
                            e.getMessage();
                        }
                        break;

                    case "user":
                        try{
                            Role userRole = roleRepository.findByNom(RoleName.ROLE_USER);
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
            user.setUsername(singupForm.getUsername());
            user.setVille(singupForm.getVille());
            user.setAdresse(singupForm.getAdresse());
            user.setNumcni(singupForm.getNumcni());
            user.setRole(roles);
            serviceUser.save(user);
            return ResponseEntity.ok().body("Utilidateur ajouté avec success");
        }catch (Exception e){
            e.getMessage();
            return  new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @PutMapping(path = "/update", params = "id")
    public ResponseEntity<User> updateUser(@RequestBody() User user, @RequestParam() Integer id){
        try{
            return new ResponseEntity<>(serviceUser.update(user,id),HttpStatus.OK) ;
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping(path = "/delete", params = "id")
    public ResponseEntity<?> deleteUser(@RequestParam() Integer id){
        try {
            serviceUser.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }
}
