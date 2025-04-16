package com.ghost.uwhub.msvc_users.domain.model;

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
public class User {
    private String id;
    private String name;
    private String lastname;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String profilePictureUrl;
    private AthleteStats athleteStats;
    private Coach coach;
    private Judge judge;   
}
