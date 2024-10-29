package org.IngSoftware.controller;

import org.IngSoftware.model.Rol;
import org.IngSoftware.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<Rol> getAllRoles() {
        return rolService.findAllRoles();
    }

    @GetMapping("/{nombre}")
    public Rol getRolByNombre(@PathVariable String nombre) {
        return rolService.findRolByNombre(nombre).orElse(null);
    }

    @PostMapping
    public Rol createRol(@RequestBody Rol rol) {
        return rolService.saveRol(rol);
    }
}
