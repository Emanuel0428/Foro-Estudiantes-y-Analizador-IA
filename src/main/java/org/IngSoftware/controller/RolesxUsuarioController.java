package org.IngSoftware.controller;

import org.IngSoftware.service.RolesxUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/RolesxUsuario")
public class RolesxUsuarioController {

    private final RolesxUsuarioService rolesxUsuarioService;

    @Autowired
    public RolesxUsuarioController(RolesxUsuarioService rolesxUsuarioService) {
        this.rolesxUsuarioService = rolesxUsuarioService;
    }

    @GetMapping
    public RolesxUsuarioService obtenerTodosLosRolesxUsuario() {
        return rolesxUsuarioService;
    }

    @GetMapping(path = "{IdUsuario}")
    public RolesxUsuarioService obtenerRolesxUsuarioPorId(@PathVariable("IdUsuario") int IdUsuario) {
        return rolesxUsuarioService.obtenerRolesxUsuarioPorId(IdUsuario);
    }

    @DeleteMapping
    public void eliminarRolesxUsuario(@PathVariable("IdUsuario") int IdUsuario) {
        rolesxUsuarioService.eliminarRolesxUsuario(IdUsuario);
    }

    @PostMapping
    public RolesxUsuarioService guardarRolesxUsuario(@RequestBody RolesxUsuarioService rolesxUsuario) {
        return rolesxUsuarioService.guardarRolesxUsuario(rolesxUsuario);
    }

    public RolesxUsuarioService getRolesxUsuarioService() {
        return rolesxUsuarioService;
    }
}
