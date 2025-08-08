Spring Boot - Productos y Usuarios con Seguridad

Este proyecto es una aplicación CRUD desarrollada con Spring Boot que gestiona productos y usuarios, implementando autenticación y autorización con Spring Security.  
Incluye pruebas con Postman y almacenamiento de usuarios en memoria.

 Tecnologías utilizadas
	Java
	Spring Boot
	Spring Data JPA
	Spring Security
	MySQL / MariaDB (XAMPP)
	Maven
	Postman (para pruebas de API)
	Visual Studio Code

Funcionalidades
	Módulo Productos
	Registro de nuevos productos.
	Listado de productos existentes.
	Actualización de datos de productos.
	Eliminación de productos.

Módulo Usuarios
	Creación de usuarios.
	Listado de usuarios.
	Eliminación de usuarios.
	Seguridad con usuarios en memoria para login.
	Rutas protegidas por roles.

Seguridad (Spring Security)
	Usuarios en memoria configurados en la clase de seguridad.
	Roles: `USER` y `ADMIN`.
	Rutas públicas y privadas.
	Acceso restringido según el rol.
	Autenticación probada con Postman.

Requisitos
	Java 17 o superior.
	Maven instalado.
	XAMPP en ejecución con base de datos configurada.
	Postman para pruebas de API.
