package org.IngSoftware.repository;

import org.IngSoftware.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    List<Publicacion> findByEstadoPublicacion(String estadoPublicacion);
}
