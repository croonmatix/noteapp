package com.example.noteapp.config;

import com.example.noteapp.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * Configuración de seguridad utilizando SecurityFilterChain en lugar de WebSecurityConfigurerAdapter.
     * @param http Configuración de HTTP Security
     * @return El objeto SecurityFilterChain con la configuración de seguridad
     * @throws Exception Si ocurre algún error en la configuración
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                //.requestMatchers("/api/auth/**").permitAll()  // Usamos `requestMatchers` en lugar de `antMatchers`
                //.requestMatchers("/api/auth/**", "/api/users/register").permitAll()
                .requestMatchers("/api/auth/**", "/api/users/register", "/api/notes/create").permitAll()
                .anyRequest().authenticated()           // Requiere autenticación para otros endpoints
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Sin manejo de sesiones

        // Agregar el filtro de JWT
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();  // Devolver la configuración
    }
}