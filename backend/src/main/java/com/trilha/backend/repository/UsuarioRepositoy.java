package com.trilha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trilha.backend.models.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepositoy extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
