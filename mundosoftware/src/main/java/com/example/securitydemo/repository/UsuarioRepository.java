package com.example.securitydemo.repository;

import com.example.securitydemo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar por correo y contraseña (para login)
    Usuario findByCorreoAndContraseña(String correo, String contraseña);

    // Buscar solo por correo (por si ya existe)
    Usuario findByCorreo(String correo);
}
