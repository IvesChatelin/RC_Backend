package com.example.rapidoscar_backend.payload;

import com.example.rapidoscar_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipale implements org.springframework.security.core.userdetails.UserDetails {

    private int id;
    private String nom;
    private String prenom;
    private int telephone;
    private String email;
    private int numcni;
    private String username;
    private String ville;
    private String adresse;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipale(Integer id, String nom, String prenom, Integer telephone, String email, String username, String ville, String adresse, String password, List<GrantedAuthority> authorities) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone =  telephone;
        this.email = email;
        this.username = username;
        this.ville = ville;
        this.adresse = adresse;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipale Detail(User user){

        List<GrantedAuthority> authorities = user.getRole().stream().map(role ->
                new SimpleGrantedAuthority(role.getNom().name())
        ).collect(Collectors.toList());

        return new UserPrincipale(
                user.getId(),
                user.getNom(),
                user.getPrenom(),
                user.getTelephone(),
                user.getEmail(),
                user.getUsername(),
                user.getVille(),
                user.getAdresse(),
                user.getPassword(),
                authorities
        );

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrincipale user = (UserPrincipale) o;
        return Objects.equals(id, user.id);
    }
}
