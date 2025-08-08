package com.example.securitydemo.controller;

import com.example.securitydemo.model.Usuario;
import com.example.securitydemo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Registrar nuevo usuario
    @PostMapping("/registrar")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
    Usuario usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getCorreo(), usuario.getContraseña());
        if (usuarioAutenticado != null) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }

    @GetMapping("/recuperar")
    public ResponseEntity<String> recuperarContraseña(@RequestParam String correo) {
    Usuario usuario = usuarioService.buscarPorCorreo(correo);
      if (usuario != null) {
         // Simula el envío de correo
         return ResponseEntity.ok("Se ha enviado un correo con instrucciones para recuperar la contraseña.");
         } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Correo no registrado");
        }
    }
}

