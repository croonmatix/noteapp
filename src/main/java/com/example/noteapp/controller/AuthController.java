package com.example.noteapp.controller;

import com.example.noteapp.dto.AuthRequest;
import com.example.noteapp.dto.AuthResponse;
import com.example.noteapp.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // Estas credenciales son solo de ejemplo; en un proyecto real debes validar con una base de datos
    private final String DEMO_USERNAME = "admin";
    private final String DEMO_PASSWORD = "admin123";

    /**
     * Endpoint para login que genera un token JWT.
     * @param request Objeto que contiene el nombre de usuario y la contraseña.
     * @return El token JWT en el cuerpo de la respuesta.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // Verifica si las credenciales son correctas (esto en un proyecto real debe ser validado en la base de datos)
        if (DEMO_USERNAME.equals(request.getUsername()) && DEMO_PASSWORD.equals(request.getPassword())) {
            // Genera un token JWT
            String token = jwtTokenProvider.generateToken(request.getUsername());
            return ResponseEntity.ok(new AuthResponse(token)); // Retorna el token JWT
        } else {
            return ResponseEntity.status(401).body(null); // Si las credenciales no son correctas, responde con error 401
        }
    }
}