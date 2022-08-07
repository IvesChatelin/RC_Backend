package com.example.rapidoscar_backend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponce {

    private String token;
    private String type = "Bearer";
    private String username;
    private String email;
    private int id;
    private List<String> role;

    public JwtResponce(String token, String username, String email, int id,List<String> role){
        this.id = id;
        this.username = username;
        this.email = email;
        this.token = token;
        this.role = role;
    }

    public JwtResponce(String token){
        this.token = token;
    }

    public String getAccessToken() {
        return token;
    }

    //public void setAccessToken(String accessToken) {this.token = accessToken;}

    public String getTokenType() {
        return type;
    }

    //public void setTokenType(String tokenType) {this.type = tokenType;}
}
