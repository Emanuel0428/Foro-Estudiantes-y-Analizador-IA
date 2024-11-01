package org.IngSoftware.service;

import org.IngSoftware.model.Roles;
import org.IngSoftware.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public List<Roles> obtenerTodosLosRoles() {
        return rolesRepository.findAll();
    }

    public Optional<Roles> obtenerRolPorId(int IdRol) {
        return rolesRepository.findById(IdRol);
    }

    public Optional<Roles> obtenerRolPorNombre(String DescpRol) {
        return rolesRepository.findByNombre(DescpRol);
    }
}
