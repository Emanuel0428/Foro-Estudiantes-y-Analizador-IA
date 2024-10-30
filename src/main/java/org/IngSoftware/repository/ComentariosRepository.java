package org.IngSoftware.repository;

import org.IngSoftware.model.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {

    void deleteByPublicacion(int IdPublicacion);

    void deleteByUsuario(int IdUsuario);

    List<Comentarios> findByPublicacion(int idPublicacion);

    List<Comentarios> findByUsuario(int idUsuario);
}
