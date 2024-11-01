package org.IngSoftware.repository;

import org.IngSoftware.model.RolesxUsuario;
import org.IngSoftware.service.RolesxUsuarioService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolesxUsuariosRepository {

    void deleteByUsuario(int IdUsuario);

    void deleteByRol(int IdRol);

    void deleteByUsuarioAndRol(int IdUsuario, int IdRol);


    Object findById(int idUsuario);

    Object save(RolesxUsuarioService rolesxUsuario);
}
