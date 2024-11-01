package org.IngSoftware.service;

import org.IngSoftware.repository.RolesxUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesxUsuarioService {

    private final RolesxUsuariosRepository rolesxUsuariosRepository;

    @Autowired
    public RolesxUsuarioService(RolesxUsuariosRepository rolesxUsuariosRepository) {
        this.rolesxUsuariosRepository = rolesxUsuariosRepository;
    }

    public void eliminarRolesPorUsuario(int IdUsuario) {
        rolesxUsuariosRepository.deleteByUsuario(IdUsuario);
    }

    public void eliminarRolesPorRol(int IdRol) {
        rolesxUsuariosRepository.deleteByRol(IdRol);
    }

    public void eliminarRolesPorUsuarioYRol(int IdUsuario, int IdRol) {
        rolesxUsuariosRepository.deleteByUsuarioAndRol(IdUsuario, IdRol);
    }

    public RolesxUsuarioService obtenerRolesxUsuarioPorId(int idUsuario) {
        return (RolesxUsuarioService) rolesxUsuariosRepository.findById(idUsuario);
    }

    public void eliminarRolesxUsuario(int idUsuario) {
        rolesxUsuariosRepository.deleteByUsuario(idUsuario);
    }

    public RolesxUsuarioService guardarRolesxUsuario(RolesxUsuarioService rolesxUsuario) {
        return (RolesxUsuarioService) rolesxUsuariosRepository.save(rolesxUsuario);
    }
}