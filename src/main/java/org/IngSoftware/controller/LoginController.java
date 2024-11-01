package org.IngSoftware.controller;

import org.IngSoftware.model.Usuario;
import org.IngSoftware.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Asegúrate de importar esto
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Inyección del encoder

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam("correo") String correo,
                                @RequestParam("contrasena") String contrasena,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        Optional<Usuario> usuarioOpt = usuarioService.obtenerUsuarioPorCorreo(correo);

        if (usuarioOpt.isPresent() && passwordEncoder.matches(contrasena, usuarioOpt.get().getContraseña())) {
            model.addAttribute("usuario", usuarioOpt.get());
            return "redirect:/home";  // Redirige a la página principal
        } else {
            redirectAttributes.addFlashAttribute("error", "Credenciales incorrectas");
            return "redirect:/login";
        }
    }

    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam("correo") String correo,
                                   @RequestParam("contrasena") String contrasena,
                                   RedirectAttributes redirectAttributes) {
        // Validar el correo
        if (!correo.endsWith("@upb.edu.co")) {
            redirectAttributes.addFlashAttribute("error", "El correo debe ser @upb.edu.co");
            return "redirect:/registro"; // Redirige al formulario de registro
        }

        // Validar la contraseña
        if (!validarContrasena(contrasena)) {
            redirectAttributes.addFlashAttribute("error", "La contraseña debe tener al menos 8 caracteres, una letra mayúscula, una letra minúscula y un número.");
            return "redirect:/registro"; // Redirige al formulario de registro
        }

        // Encripta la contraseña antes de guardarla
        String contrasenaEncriptada = passwordEncoder.encode(contrasena);

        Usuario usuario = new Usuario();
        usuario.setCorreo(correo);
        usuario.setContraseña(contrasenaEncriptada);

        usuarioService.guardarUsuario(usuario);

        redirectAttributes.addFlashAttribute("mensaje", "Usuario registrado exitosamente");
        return "redirect:/login"; // Redirige al formulario de login
    }


    private boolean validarContrasena(String contrasena) {
        return contrasena.length() >= 8 &&
                contrasena.matches(".*[A-Z].*") && // Al menos una letra mayúscula
                contrasena.matches(".*[a-z].*") && // Al menos una letra minúscula
                contrasena.matches(".*\\d.*"); // Al menos un número
    }
}
