package org.IngSoftware.service;

import org.IngSoftware.model.Usuario;
import org.IngSoftware.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(int DocId) {
        return usuarioRepository.findById((long) DocId);
    }

    public Optional<Usuario> obtenerUsuarioPorCorreo(String Correo) {
        return usuarioRepository.findByCorreo(Correo);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(int DocId) {
        usuarioRepository.deleteById((long) DocId);
    }

    public boolean existeUsuarioPorCorreo(String Correo) {
        return usuarioRepository.existsByCorreo(Correo);
    }

    public Optional<Usuario> autenticarUsuario(String correo, String contrasena) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (passwordEncoder.matches(contrasena, usuario.getContraseña())) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }


}