package com.example.rapidoscar_backend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingupForm {
    private int id;
    private String nom;
    private String prenom;
    private String Ville;
    private String adresse;
    private int telephone;
    private String email;
    private int numcni;
    private String username;
    private Set<String> role;
    private String password;
}
