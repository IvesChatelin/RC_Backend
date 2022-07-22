package com.example.rapidoscar_backend.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UserPrincipe implements org.springframework.security.core.userdetails.UserDetails {

    private int id;
    private String nom;
    private String prenom;
    private int telephone;
    private String email;
    private int numcni;
    private String username;

    @JsonIgnore
    private String passwd;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipe(Integer id, String nom, String prenom, Integer telephone, String email, Integer numcni, String username, List<GrantedAuthority> authorities) {
    }

    public static UserPrincipe Detail(User user){

        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrincipe(
                user.getId(),
                user.getNom(),
                user.getPrenom(),
                user.getTelephone(),
                user.getEmail(),
                user.getNumcni(),
                user.getUsername(),
                authorities
        );

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrincipe user = (UserPrincipe) o;
        return Objects.equals(id, user.id);
    }
}
