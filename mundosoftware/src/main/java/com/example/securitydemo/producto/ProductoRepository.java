package com.example.securitydemo.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Buscar productos por categoría
    List<Producto> findByCategoria(String categoria);

    // Buscar productos por nombre (contiene, sin importar mayúsculas)
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}

