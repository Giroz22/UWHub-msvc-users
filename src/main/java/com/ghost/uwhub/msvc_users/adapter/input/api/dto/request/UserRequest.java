package com.ghost.uwhub.msvc_users.adapter.input.api.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserRequest {

    @NotBlank(message = "El nombre es requerido")
    private String name;
    
    private String lastname;
    
    @Email(message = "El correo no es valido")
    @NotBlank(message = "El correo es requerido")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    private String profilePictureUrl;
}
