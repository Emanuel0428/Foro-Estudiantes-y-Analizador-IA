package org.IngSoftware.service;

import org.IngSoftware.model.Publicaciones;
import org.IngSoftware.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;

    @Autowired
    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    public List<Publicaciones> findAllPublicaciones() {
        return publicacionRepository.findAll();
    }

    public Optional<Publicaciones> findPublicacionById(Long id) {
        return publicacionRepository.findById(id);
    }

    public List<Publicaciones> findPublicacionesByEstado(String estado) {
        return publicacionRepository.findByEstadoPublicacion(estado);
    }

    public Publicaciones savePublicacion(Publicaciones publicaciones) {
        return publicacionRepository.save(publicaciones);
    }

    public void deletePublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }
}
