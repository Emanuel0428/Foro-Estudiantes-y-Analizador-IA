package org.IngSoftware.service;

import org.IngSoftware.model.Rol;
import org.IngSoftware.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> findAllRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> findRolByNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }

    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }
}
