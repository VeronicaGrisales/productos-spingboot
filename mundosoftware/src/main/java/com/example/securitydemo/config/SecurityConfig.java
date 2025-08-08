package com.example.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.GetMapping;


//Configuración de seguridad utilizando Spring Security.

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Crea usuarios en memoria con roles específicos.

    @Bean
    public UserDetailsService usersDetailsService() {

        var manager = new InMemoryUserDetailsManager();
        manager.createUser(User
        .withUsername("admin")
        .password("{noop}admin123")     //"{noop}" significa que la contraseña no tiene codificación
        .roles("ADMIN")
        .build());
        
        manager.createUser(User
        .withUsername("user")
        .password("{noop}user123")
        .roles("USER")
        .build());
        return manager;
    }

//Define las reglas de seguridad: rutas públicas, protegidas, login y logout.

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/usuarios/registrar", "/usuarios/login", "/usuarios/recuperar", "/css/**", "/api/productos/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
            )

            
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
                .successHandler(myAuthenticationSuccessHandler())
                .failureUrl("/login?error=true")
            )

            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            )

            .exceptionHandling(exception -> exception
                .accessDeniedPage("/access-denied")
            )

            .httpBasic(Customizer.withDefaults())
            .csrf(csrf->csrf.disable());

            

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        
    return new CustomSuccessHandler();
}
 @GetMapping("/") 
   public String iniciarSesion(){
    return "iniciarSesion";
   }

    
}
