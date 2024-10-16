package org.IngSoftware.controller;

import org.IngSoftware.model.UsuarioModel;
import org.IngSoftware.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioModel> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping
    public UsuarioModel createUsuario(@RequestBody UsuarioModel usuarioModel) {
        return usuarioService.saveUsuario(usuarioModel);
    }
}
