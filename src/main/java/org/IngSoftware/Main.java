package org.IngSoftware;

import org.IngSoftware.model.Usuario;
import org.IngSoftware.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UsuarioService usuarioService) {
        return args -> {
            // Crear un nuevo usuario para probar la conexión
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre("Juan Pérez");
            nuevoUsuario.setEmail("juan.perez@example.com");

            // Guardar el usuario en la base de datos
            usuarioService.saveUsuario(nuevoUsuario);

            // Obtener todos los usuarios y mostrarlos
            List<Usuario> usuarios = usuarioService.getAllUsuarios();
            usuarios.forEach(usuario -> {
                System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre() + ", Email: " + usuario.getEmail());
            });
        };
    }
}
