package org.IngSoftware.controller;


import org.IngSoftware.model.Roles;
import org.IngSoftware.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Roles")
public class RolesController {

    private final RolesService rolesService;

    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    public ResponseEntity<List<Roles>> obtenerTodosLosRoles() {
        List<Roles> roles = rolesService.obtenerTodosLosRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping(path = "{IdRol}")
    public ResponseEntity<Optional<Roles>> obtenerRolPorId(@PathVariable("IdRol") int IdRol) {
        Optional<Roles> rol = rolesService.obtenerRolPorId(IdRol);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @GetMapping(path = "/Nombre/{DescpRol}")
    public ResponseEntity<Optional<Roles>> obtenerRolPorNombre(@PathVariable("DescpRol") String DescpRol) {
        Optional<Roles> rol = rolesService.obtenerRolPorNombre(DescpRol);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

}
