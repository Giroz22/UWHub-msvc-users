package com.waveghost.msvc_users_security.adapter.input.api.dtos.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
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
public class RegisterRequest {
    @NotBlank(message = "El nombre es requerido")
    private String name;
    
    @NotBlank(message = "El correo es requerido")
    @Email(message = "Correo invalido")
    private String email;
    
    @NotBlank(message = "La contraseña es requerida")
    @Length(min = 8, message = "La contraseña debe tener minimo 8 caracteres")
    private String password;
}
