package com.example.noteapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
	@NotEmpty(message = "El nombre de usuario no puede estar vacío")
    private String username;
	
	@NotEmpty(message = "La contraseña no puede estar vacía")
    private String password;
	
	@NotNull(message = "El email no puede ser nulo")
    @Email(message = "El email no tiene un formato válido")
    private String email;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}      
}
