package com.example.noteapp.controller;

import com.example.noteapp.dto.UserDTO;
import com.example.noteapp.entity.User;
import com.example.noteapp.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            // Si hay errores de validación, devolver un mensaje con los errores
            StringBuilder errorMessages = new StringBuilder("Errores de validación: ");
            result.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages.toString());
        }

        // Si las validaciones pasaron, crear el usuario
        User createdUser = userService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente: " + createdUser.getUsername());
    }
}