package org.IngSoftware.controller;

import org.IngSoftware.model.Usuario;
import org.IngSoftware.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping(path = "{DocId}")
    public ResponseEntity<Optional<Usuario>> obtenerUsuarioPorId(@PathVariable("DocId") int DocId) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(DocId);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping(path = "/Correo/{Correo}")
    public ResponseEntity<Optional<Usuario>> obtenerUsuarioPorCorreo(@PathVariable("Correo") String Correo) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorCorreo(Correo);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{DocId}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("DocId") int DocId) {
        usuarioService.eliminarUsuario(DocId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/Correo/{Correo}/existe")
    public ResponseEntity<Boolean> existeUsuarioPorCorreo(@PathVariable("Correo") String Correo) {
        boolean existe = usuarioService.existeUsuarioPorCorreo(Correo);
        return new ResponseEntity<>(existe, HttpStatus.OK);
    }
    
}
