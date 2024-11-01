package org.IngSoftware.repository;

import org.IngSoftware.model.Publicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PublicacionRepository extends JpaRepository<Publicaciones, Long> {
    List<Publicaciones> findByUsuario(int IdUsuario);

}