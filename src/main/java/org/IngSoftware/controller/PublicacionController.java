package org.IngSoftware.controller;

import org.IngSoftware.model.Publicacion;
import org.IngSoftware.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    private final PublicacionService publicacionService;

    @Autowired
    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @GetMapping
    public List<Publicacion> getAllPublicaciones() {
        return publicacionService.findAllPublicaciones();
    }

    @GetMapping("/{id}")
    public Publicacion getPublicacionById(@PathVariable Long id) {
        return publicacionService.findPublicacionById(id).orElse(null);
    }

    @PostMapping
    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.savePublicacion(publicacion);
    }

    @DeleteMapping("/{id}")
    public void deletePublicacion(@PathVariable Long id) {
        publicacionService.deletePublicacion(id);
    }
}
