package com.example.securitydemo.controller;

import com.example.securitydemo.model.Usuario;
//import com.example.securitydemo.producto.Producto;
import com.example.securitydemo.service.UsuarioService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") 
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Crear un nuevo usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    
    @GetMapping ("/registerNuevo")
    public ModelAndView registro (Model model) {
        ModelAndView modelAndView = new ModelAndView();
        // Usuario usuario = new Usuario();
        // usuario.setCorreo("juan@example.com");
        // modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("register.html");
        return modelAndView;
        // Usuario usuario = new Usuario();
        // model.addAttribute("usuario", usuario);
        // return "register";
    }

    @PostMapping ("/register")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        // ModelAndView modelAndView = new ModelAndView();
        // modelAndView.addObject("usuario", new Usuario());
        // modelAndView.setViewName("login.html");
        usuarioService.guardarUsuario(usuario);
        return "redirect:/login"; // o la vista que quieras
}

    // // Registrar nuevo usuario
    // @PostMapping ("/register")
    // public Usuario registrarUsuario(@RequestBody Usuario usuario) {
    //     return usuarioService.guardarUsuario(usuario);
    // }
 
    @GetMapping("/login")
    public String login() {
        return "login"; // login.html en templates
    }

    // @PostMapping ("/login")
    // public ResponseEntity<String> login(@RequestBody Usuario usuario) {
    // Usuario usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getCorreo(), usuario.getContraseña());
    //     if (usuarioAutenticado != null) {
    //         return ResponseEntity.ok("Inicio de sesión exitoso");
    //     } else {
    //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    //     }
    // }

    @GetMapping ("/recuperar")
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

