package com.trilha.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trilha.backend.models.Usuario;
import com.trilha.backend.security.AuthenticationDTO;
import com.trilha.backend.security.TokenService;

@Controller
public class LoginController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

 @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.geradorDeToken((Usuario)auth.getPrincipal());
        
        try {
            auth = authenticationManager.authenticate(usernamePassword);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
