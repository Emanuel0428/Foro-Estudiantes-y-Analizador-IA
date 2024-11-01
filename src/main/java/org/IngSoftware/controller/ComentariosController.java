package org.IngSoftware.controller;

import org.IngSoftware.model.Comentarios;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.IngSoftware.service.ComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Comentarios")
public class ComentariosController {

    private final ComentariosService comentariosService;

    @Autowired
    public ComentariosController(ComentariosService comentariosService) {
        this.comentariosService = comentariosService;
    }

    @GetMapping(path = "{IdComentario}")
    public Comentarios obtenerComentarioPorId(@PathVariable("IdComentario") int IdComentario) {
        return comentariosService.obtenerComentarioPorId(IdComentario);
    }

    @PostMapping
    public Comentarios guardarComentario(@RequestBody Comentarios comentario) {
        return comentariosService.guardarComentario(comentario);
    }

    @DeleteMapping(path = "{IdComentario}")
    public void eliminarComentario(@PathVariable("IdComentario") int IdComentario) {
        comentariosService.eliminarComentario(IdComentario);
    }

    @GetMapping(path = "/Publicacion/{IdPublicacion}")
    public List<Comentarios> obtenerComentariosPorPublicacion(@PathVariable("IdPublicacion") int IdPublicacion) {
        return comentariosService.obtenerComentariosPorPublicacion(IdPublicacion);
    }

    @GetMapping(path = "/Usuario/{IdUsuario}")
    public List<Comentarios> obtenerComentariosPorUsuario(@PathVariable("IdUsuario") int IdUsuario) {
        return comentariosService.obtenerComentariosPorUsuario(IdUsuario);
    }

    @DeleteMapping(path = "/Publicacion/{IdPublicacion}")
    public void eliminarComentarioPorPublicacion(@PathVariable("IdPublicacion") int IdPublicacion) {
        comentariosService.eliminarComentarioPorPublicacion(IdPublicacion);
    }

    @DeleteMapping(path = "/Usuario/{IdUsuario}")
    public void eliminarComentarioPorUsuario(@PathVariable("IdUsuario") int IdUsuario) {
        comentariosService.eliminarComentarioPorUsuario(IdUsuario);
    }

    @DeleteMapping(path = "/{IdComentario}")
    public void eliminarComentarioPorId(@PathVariable("IdComentario") int IdComentario) {
        comentariosService.eliminarComentarioPorId(IdComentario);
    }


}
