package com.ghost.uwhub.msvc_users.adapter.input.api.dto.response;

import java.time.LocalDate;

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
public class UserResponse {
    private String id;
    private String name;
    private String lastname;
    private LocalDate dateOfBirth;
    private String profilePictureUrl;
    private String email;
    private String password;
}
