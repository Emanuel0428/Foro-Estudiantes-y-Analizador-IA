package org.IngSoftware.controller;

import org.IngSoftware.model.Usuario;
import org.IngSoftware.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Inyección del encoder

    @GetMapping("/login")
    public String mostrarFormularioLogin(@RequestParam(value = "logout", required = false) String logout,
                                         @RequestParam(value = "expired", required = false) String expired,
                                         Model model) {
        if (logout != null) {
            model.addAttribute("Dmessage", "Has cerrado sesión con éxito.");
        }
        if (expired != null) {
            model.addAttribute("message", "Tu sesión ha expirado. Por favor, inicia sesión de nuevo.");
        }
        return "login";
    }


    @PostMapping("/login")
    public String procesarLogin(@RequestParam("correo") String correo,
                                @RequestParam("contrasena") String contrasena,
                                RedirectAttributes redirectAttributes) {
        Optional<Usuario> usuarioOpt = usuarioService.obtenerUsuarioPorCorreo(correo);

        if (usuarioOpt.isPresent() && passwordEncoder.matches(contrasena, usuarioOpt.get().getContraseña())) {
            redirectAttributes.addFlashAttribute("usuario", usuarioOpt.get());
            return "redirect:/home";  // Redirige a la página principal
        } else {
            redirectAttributes.addFlashAttribute("error", "Credenciales incorrectas");
            return "redirect:/login";
        }
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        return "registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam("correo") String correo,
                                   @RequestParam("contrasena") String contrasena,
                                   RedirectAttributes redirectAttributes) {
        if (!correo.endsWith("@upb.edu.co")) {
            redirectAttributes.addFlashAttribute("error", "El correo debe ser @upb.edu.co");
            return "redirect:/registro"; // Redirige al formulario de registro
        }

        // Verificar si el usuario ya existe
        if (usuarioService.existeUsuarioPorCorreo(correo)) {
            redirectAttributes.addFlashAttribute("error", "El correo ya está registrado");
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
}
