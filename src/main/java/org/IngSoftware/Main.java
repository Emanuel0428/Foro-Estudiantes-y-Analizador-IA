package org.IngSoftware;

import org.IngSoftware.model.UsuarioModel;
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
            UsuarioModel nuevoUsuarioModel = new UsuarioModel();
            nuevoUsuarioModel.setNombre("Juan Pérez");
            nuevoUsuarioModel.setEmail("juan.perez@example.com");

            // Guardar el usuario en la base de datos
            usuarioService.saveUsuario(nuevoUsuarioModel);

            // Obtener todos los usuarios y mostrarlos
            List<UsuarioModel> usuarioModels = usuarioService.getAllUsuarios();
            usuarioModels.forEach(usuarioModel -> {
                System.out.println("ID: " + usuarioModel.getId() + ", Nombre: " + usuarioModel.getNombre() + ", Email: " + usuarioModel.getEmail());
            });
        };
    }
}
