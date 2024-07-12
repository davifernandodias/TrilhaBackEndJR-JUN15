package com.trilha.backend.models;

public enum UsuarioRole {
    COLABORADOR("colaborador");

    private String role;

    UsuarioRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
