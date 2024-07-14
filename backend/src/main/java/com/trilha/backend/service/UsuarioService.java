package com.trilha.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trilha.backend.models.Usuario;
import com.trilha.backend.repository.UsuarioRepositoy;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepositoy usuarioRepositoy;



    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepositoy.save(usuario);
    }

    public List<Usuario> listaDeTodosUsuario() {
        return usuarioRepositoy.findAll();
    }
}
