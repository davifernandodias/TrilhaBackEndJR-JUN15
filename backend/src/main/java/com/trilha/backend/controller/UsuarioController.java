package com.trilha.backend.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trilha.backend.models.Usuario;

import com.trilha.backend.service.UsuarioService;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Operation(summary = "Criar usuarios")
    @ApiResponse(responseCode = "201", description = "Usuario criada com sucesso")
    @PostMapping("/registro")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(usuario));
    }
    @Operation(summary = "Consultar todos usuarios")
    @ApiResponse(responseCode = "200",description = "Usuarios encontradas")
    @GetMapping("/todos/usuarios")
    public ResponseEntity<List<Usuario>> consultarTodosUsuarios(){
        return ResponseEntity.ok().body(usuarioService.listaDeTodosUsuario());
    }
}
