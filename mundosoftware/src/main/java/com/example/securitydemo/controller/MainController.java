package com.example.securitydemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Controlador principal para manejar las rutas accesibles por los usuarios.

@Controller
public class MainController {

   @ResponseBody    
    public String publicPage() {
        return "Esta es una página pública.";
    }

    @GetMapping("/user")
    @ResponseBody
    public String userPage() {
        return "Bienvenido, usuario.";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String adminPage() {
        return "Bienvenido, administrador.";
    }

    
    @GetMapping("/access-denied")
    public String accessDenied() {
    return "access-denied";
    }
}
