package com.example.noteapp.service;

import com.example.noteapp.dto.UserDTO;
import com.example.noteapp.entity.User;
import com.example.noteapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDTO userDTO) {
        // Verificar si el nombre de usuario ya existe
        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new RuntimeException("El nombre de usuario ya está registrado.");
        }

        // Verificar si el email ya existe
        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new RuntimeException("El email ya está registrado.");
        }

        // Crear el nuevo usuario
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword()); // Aquí deberías encriptar la contraseña antes de guardarla
        user.setEmail(userDTO.getEmail());

        return userRepository.save(user);
    }
}