package com.ghost.uwhub.msvc_users.adapter.input.api.dto.request;

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
public class UserLogin {
    
    private String email;
    private String password;
}
