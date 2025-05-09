package com.waveghost.msvc_users_security.domain.port.input;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.LoginRequest;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.RegisterRequest;

public interface AuthServicePort extends UserDetailsService{
    public String login(LoginRequest user);
    public String register(RegisterRequest user);
    public void updatePassword(String username, String oldPassword, String newPassword);
}
