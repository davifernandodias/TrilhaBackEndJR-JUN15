package com.trilha.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.trilha.backend.models.Usuario;
import com.trilha.backend.repository.UsuarioRepositoy;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepositoy usuarioRepositoy;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepositoy.save(usuario);
    }

    public List<Usuario> listaDeTodosUsuario() {
        return usuarioRepositoy.findAll();
    }
}
