package com.example.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.securitydemo.model.Usuario;

@Controller
public class registerController {

    @GetMapping("/register")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register"; // Nombre de la vista Thymeleaf
    }

    @PostMapping("/register")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {
        // Validar y guardar el usuario
        if (result.hasErrors()) {
            return "register"; // Volver a la vista de registro si hay errores
        }
        // Lógica para guardar el usuario
        // Si hay un error (por ejemplo, email ya en uso), agregar un mensaje de error
        // model.addAttribute("error", "El correo ya está en uso.");
        
        return "redirect:/login"; // Redirigir a la página de login después del registro exitoso
    }
}

