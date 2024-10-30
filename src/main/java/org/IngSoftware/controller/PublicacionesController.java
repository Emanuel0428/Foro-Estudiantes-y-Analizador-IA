package org.IngSoftware.controller;

import org.IngSoftware.model.Publicaciones;
import org.IngSoftware.service.PublicacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Publicaciones")
public class PublicacionesController {

    private final PublicacionesService publicacionesService;

    @Autowired
    public PublicacionesController(PublicacionesService publicacionesService) {
        this.publicacionesService = publicacionesService;
    }

    @GetMapping
    public List<Publicaciones> obtenerTodasLasPublicaciones() {
        return publicacionesService.obtenerTodasLasPublicaciones();
    }

    @GetMapping(path = "{IdPublicacion}")
    public Publicaciones obtenerPublicacionPorId(@PathVariable("IdPublicacion") int IdPublicacion) {
        return publicacionesService.obtenerPublicacionPorId(IdPublicacion).orElse(null);
    }

    @PostMapping
    public Publicaciones guardarPublicacion(@RequestBody Publicaciones publicacion) {
        return publicacionesService.guardarPublicacion(publicacion);
    }

    @DeleteMapping(path = "{IdPublicacion}")
    public void eliminarPublicacion(@PathVariable("IdPublicacion") int IdPublicacion) {
        publicacionesService.eliminarPublicacion(IdPublicacion);
    }

    @GetMapping(path = "/Usuario/{IdUsuario}")
    public List<Publicaciones> obtenerPublicacionesPorUsuario(@PathVariable("IdUsuario") int IdUsuario) {
        return publicacionesService.obtenerPublicacionesPorUsuario(IdUsuario);
    }
}
