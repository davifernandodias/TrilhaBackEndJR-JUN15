package com.trilha.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.trilha.backend.models.Usuario;
import com.trilha.backend.repository.UsuarioRepositoy;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepositoy usuarioRepositoy;

    public void salvarUsuario(Usuario usuario,String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  //ENCODER SENHA -> CRIPTOGRAFIA DA SENHA
        usuario.setUser(username);
        usuario.setPassword(encoder.encode(password));
        usuarioRepositoy.save(usuario);
    }
}
