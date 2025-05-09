package com.waveghost.msvc_users_security.adapter.input.api.dtos.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record UpdatePasswordRequest(
    @NotBlank(message = "La contraseña es requerida")
    String oldPassword,

    @NotBlank(message = "La contraseña es requerida")
    @Length(min = 8, message = "La contraseña debe tener minimo 8 caracteres") 
    String newPassword
)
{} 
