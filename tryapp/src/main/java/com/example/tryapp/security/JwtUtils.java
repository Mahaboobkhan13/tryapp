package com.example.tryapp.security;

import com.example.tryapp.exception.NotFoundException;
import com.example.tryapp.model.Students;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static String secret="This_is_Secret";
     public String tokenGenerate(Students students){
         Claims claims = Jwts.claims()
                 .setIssuedAt(new Date())
                 .setExpiration(new Date(System.currentTimeMillis()+640000000))
                 .setId(students.getName()+"hAHA");
         claims.put("name",students.getName());
         return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,secret).compact();
     }

     public void verify(String auth) throws Exception {
         try {
             Jwts.parser().setSigningKey(secret).parseClaimsJws(auth);
         }
         catch (Exception e){
             throw new NotFoundException("invalid Token ");
         }

     }

}
