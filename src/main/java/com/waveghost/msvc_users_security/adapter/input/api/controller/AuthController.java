package com.waveghost.msvc_users_security.adapter.input.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.LoginRequest;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.RegisterRequest;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.UpdatePasswordRequest;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.response.AuthResponse;
import com.waveghost.msvc_users_security.domain.port.input.AuthServicePort;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServicePort authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok().body(
            new AuthResponse(this.authService.login(request))
        );
    }
    
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok().body(
            new AuthResponse(this.authService.register(request))
        );
    }

    @PostMapping("/update-password")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> updatePassword(Authentication authentication, @RequestBody @Valid UpdatePasswordRequest request) {
        String username = authentication.getName();

        this.authService.updatePassword(username, request.oldPassword(), request.newPassword());

        return ResponseEntity.ok().body("La contraseña se actualizo correctamente");
    }
    
}
