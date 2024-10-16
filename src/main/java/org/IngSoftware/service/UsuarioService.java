package org.IngSoftware.service;

import org.IngSoftware.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.IngSoftware.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel saveUsuario(UsuarioModel usuarioModel) {
        usuarioRepository.save(usuarioModel);
        return usuarioModel;
    }

    public List<UsuarioModel> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
}
