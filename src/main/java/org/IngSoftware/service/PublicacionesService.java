package org.IngSoftware.service;

import org.IngSoftware.model.Publicaciones;
import org.IngSoftware.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublicacionesService {

    private final PublicacionRepository publicacionRepository;

    @Autowired
    public PublicacionesService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    public List<Publicaciones> obtenerTodasLasPublicaciones() {
        return publicacionRepository.findAll();
    }

    public Optional<Publicaciones> obtenerPublicacionPorId(int IdPublicacion) {
        return publicacionRepository.findById((long) IdPublicacion);
    }

    public Publicaciones guardarPublicacion(Publicaciones publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public void eliminarPublicacion(int IdPublicacion) {
        publicacionRepository.deleteById((long) IdPublicacion);
    }

    public List<Publicaciones> obtenerPublicacionesPorUsuario(int IdUsuario) {
        return publicacionRepository.findByUsuario(IdUsuario);
    }

}
