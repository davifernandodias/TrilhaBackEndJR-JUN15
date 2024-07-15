package com.trilha.backend.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.trilha.backend.models.Usuario;
import com.trilha.backend.repository.UsuarioRepositoy;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepositoy usuarioRepositoy;

    @Override
    protected void doFilterInternal(@SuppressWarnings("null") HttpServletRequest request, @SuppressWarnings("null") HttpServletResponse response, @SuppressWarnings("null") FilterChain filterChain)
            throws ServletException, IOException {
        var token = recoverToken(request);
        if (token != null) {
            try {
                var username = tokenService.validacaoToken(token);
                Optional<Usuario> usuarioDetalhesOptional = usuarioRepositoy.findByUsername(username);

                if (usuarioDetalhesOptional.isPresent()) {
                    Usuario usuarioDetalhes = usuarioDetalhesOptional.get();
                    var authentication = new UsernamePasswordAuthenticationToken(usuarioDetalhes, null,
                            usuarioDetalhes.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    // Log para quando o usuário não for encontrado
                    System.out.println("Usuário não encontrado para o token fornecido.");
                }
            } catch (Exception e) {
                // Log de erro na validação do token ou autenticação
                System.out.println("Erro ao validar token: " + e.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }

}
