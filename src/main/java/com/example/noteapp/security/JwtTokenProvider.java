package com.example.noteapp.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // Usar una clave de 256 bits generada con Keys (o puede ser una clave personalizada de 256 bits)
    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);  // Genera una clave segura de 256 bits

    private final long EXPIRATION_TIME = 86400000; // 24 horas en milisegundos

    // Generar un token JWT
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)  // Usa la clave generada
                .compact();
    }

    // Obtener el usuario (subject) del token JWT
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)  // Usa la clave generada
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // Validar si el token JWT es válido
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY)  // Usa la clave generada
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}