package com.ghost.uwhub.msvc_users.adapter.input.api.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private String name;
    private String lastname;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    private String email;
    private String profilePictureUrl;
}
