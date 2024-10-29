package org.IngSoftware.service;

import org.IngSoftware.model.Publicacion;
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

    public List<Publicacion> findAllPublicaciones() {
        return publicacionRepository.findAll();
    }

    public Optional<Publicacion> findPublicacionById(Long id) {
        return publicacionRepository.findById(id);
    }

    public List<Publicacion> findPublicacionesByEstado(String estado) {
        return publicacionRepository.findByEstadoPublicacion(estado);
    }

    public Publicacion savePublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public void deletePublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }
}
