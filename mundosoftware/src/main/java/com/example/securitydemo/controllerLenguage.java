package com.example.securitydemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerLenguage {

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // nombre del archivo login.html en templates
    }
}