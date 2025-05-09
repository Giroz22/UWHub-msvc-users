package com.waveghost.msvc_users_security.adapter.input.api.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginRequest {

    @NotBlank(message = "El correo es requerido")
    private String username;
    
    @NotBlank(message = "La contraseña es requerida")
    private String password;
}
