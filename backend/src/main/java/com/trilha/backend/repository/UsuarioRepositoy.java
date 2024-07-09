package com.trilha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trilha.backend.models.Usuario;

public interface UsuarioRepositoy extends JpaRepository<Usuario,Long> {

    
}