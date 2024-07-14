package com.trilha.backend.models;

import java.util.Collection;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique Identifier of the taks",example = "1")
    private Long id;

    @Column(name = "username", nullable = false)
    @Schema(description = "Username",example = "Davi")
    private String username;

    @Column(name = "password", nullable = false)
    @Schema(description = "Password of user",example = "Davi")
    private String password;

    @Column(name = "role", nullable = false)
    @Schema(description = "credentials",example = "employee")
    private UsuarioRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRole getRole() {
        return role = UsuarioRole.COLABORADOR;
    }

    public void setRole(UsuarioRole role) {
        this.role = role;
    }


}
