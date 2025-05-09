package com.waveghost.msvc_users_security.domain.model;

import com.waveghost.msvc_users_security.infrastructure.enums.UserRole;

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
public class RoleModel {
    private Long id;
    private UserRole userRole;
}
