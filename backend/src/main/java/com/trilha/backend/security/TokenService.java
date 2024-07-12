package com.trilha.backend.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.trilha.backend.models.Usuario;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String geradorDeToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("challenger-api")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(geradorDeExpiracaoDeTempo())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro enquanto gera o token", exception);
        }
    }

    public String validacaoToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
            .withIssuer("challenger-api")
            .build()
            .verify(token)
            .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant geradorDeExpiracaoDeTempo() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
