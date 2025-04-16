package com.ghost.uwhub.msvc_users.adapter.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Coaches")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CoachEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(mappedBy = "coach")
    private UserEntity user;
}
