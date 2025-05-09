package com.waveghost.msvc_users_security.domain.model;

import java.util.Set;

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
public class UserModel {
    private String id;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private Set<RoleModel> roles;
}
