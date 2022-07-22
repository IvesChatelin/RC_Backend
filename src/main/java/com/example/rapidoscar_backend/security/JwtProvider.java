package com.example.rapidoscar_backend.security;

import com.example.rapidoscar_backend.payload.UserPrincipe;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpiration}")
    private String jwtExpiration;

    public String generateJwtToken(Authentication authentication){
        UserPrincipe userModel = (UserPrincipe) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((userModel.getNom()))
                .setId(Long.toString(userModel.getId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS256,jwtSecret)
                .compact();
    };

    public boolean validationToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }
        catch (SignatureException e){
            logger.error("Signature du token invalide -> Message: {}", e);
        }
        catch (MalformedJwtException e){
            logger.error("Invalide token -> Message: {}", e);
        }
        catch (UnsupportedJwtException e){
            logger.error("token non supporté -> Message: {}", e);
        }
        catch (IllegalArgumentException e){
            logger.error("la valeur inserer est vide on n'est pas un string -> Message: {}");
        }
        return false;
    }

    public String getUsernameByToken(String token){
        return  Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public Integer getUserIdByToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return Integer.parseInt(claims.getId());
    }
}
