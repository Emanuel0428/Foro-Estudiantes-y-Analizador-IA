package org.IngSoftware.service;

import org.IngSoftware.model.Comentarios;
import org.IngSoftware.repository.ComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentariosService {

    private final ComentariosRepository comentariosRepository;

    @Autowired
    public ComentariosService(ComentariosRepository comentariosRepository) {
        this.comentariosRepository = comentariosRepository;
    }

    public Comentarios guardarComentario(Comentarios comentario) {
        return comentariosRepository.save(comentario);
    }

    public void eliminarComentario(int IdComentario) {
        comentariosRepository.deleteById((long) IdComentario);
    }

    public Comentarios obtenerComentarioPorId(int IdComentario) {
        return comentariosRepository.findById((long) IdComentario).orElse(null);
    }

    public void eliminarComentarioPorId(int IdComentario) {
        comentariosRepository.deleteById((long) IdComentario);
    }

    public void eliminarComentarioPorPublicacion(int IdPublicacion) {
        comentariosRepository.deleteByPublicacion(IdPublicacion);
    }

    public void eliminarComentarioPorUsuario(int IdUsuario) {
        comentariosRepository.deleteByUsuario(IdUsuario);
    }

    public List<Comentarios> obtenerComentariosPorPublicacion(int idPublicacion) {
        return comentariosRepository.findByPublicacion(idPublicacion);
    }

    public List<Comentarios> obtenerComentariosPorUsuario(int idUsuario) {
        return comentariosRepository.findByUsuario(idUsuario);
    }
}
