package org.IngSoftware.controller;

import org.IngSoftware.model.Publicaciones;
import org.IngSoftware.service.PublicacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionesService publicacionService;

    @GetMapping("/nueva")
    public String mostrarFormularioPublicacion(Model model) {
        model.addAttribute("publicacion", new Publicaciones());
        return "formPublicacion";
    }

    @PostMapping("/guardar")
    public String guardarPublicacion(Publicaciones publicacion) {
        publicacionService.guardarPublicacion(publicacion);
        return "redirect:/publicaciones";
    }

    // Método adicional para mostrar lista de publicaciones
    @GetMapping
    public String listarPublicaciones(Model model) {
        model.addAttribute("publicaciones", publicacionService.obtenerTodasLasPublicaciones());
        return "publicaciones";
    }
}
