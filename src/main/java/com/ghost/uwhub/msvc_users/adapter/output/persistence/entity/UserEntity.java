package com.ghost.uwhub.msvc_users.adapter.output.persistence.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    
    private String profilePictureUrl;

    @OneToOne()
    @JoinColumn(
        name="AthleteStats_ID"
    )
    private AthleteStatsEntity athleteStats;

    @OneToOne()
    @JoinColumn(
        name="Coach_ID"
    )
    private CoachEntity coach;

    @OneToOne()
    @JoinColumn(
        name="Judge_ID"
    )
    private JudgeEntity judge;

}
