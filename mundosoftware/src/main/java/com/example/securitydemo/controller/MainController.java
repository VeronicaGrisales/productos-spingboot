package com.example.securitydemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.securitydemo.model.Usuario;

//Controlador principal para manejar las rutas accesibles por los usuarios.

@Controller
public class MainController {

   @ResponseBody    
    public String publicPage() {
        return "Esta es una página pública.";
    }

    @GetMapping("/user")
    @ResponseBody
    public ModelAndView userPage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        // Usuario usuario = new Usuario();
        // usuario.setCorreo("juan@example.com");
        // modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("producto.html");
        return modelAndView;
       // return "Bienvenido, usuario.";
    }

    @GetMapping("/admin")
    @ResponseBody
    public ModelAndView adminPage() {
        ModelAndView modelAndView = new ModelAndView();
        // Usuario usuario = new Usuario();
        // usuario.setCorreo("juan@example.com");
        // modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("admin.html");
        return modelAndView;
       // return "Bienvenido, usuario.";
        //return "Bienvenido, administrador.";
    }

    
    @GetMapping("/access-denied")
    public String accessDenied() {
    return "access-denied";
    }
}
