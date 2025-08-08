package com.example.securitydemo.service;

import com.example.securitydemo.model.Usuario;
import com.example.securitydemo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario autenticarUsuario(String correo, String contraseña) {
    return usuarioRepository.findByCorreoAndContraseña(correo, contraseña);
    }

    public Usuario buscarPorCorreo(String correo) {
    return usuarioRepository.findByCorreo(correo);
    }


}

