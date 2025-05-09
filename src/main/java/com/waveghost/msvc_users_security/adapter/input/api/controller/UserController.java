package com.waveghost.msvc_users_security.adapter.input.api.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.UserRequest;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.response.UserResponse;
import com.waveghost.msvc_users_security.adapter.input.api.mapper.UserMapper;
import com.waveghost.msvc_users_security.domain.model.UserModel;
import com.waveghost.msvc_users_security.domain.port.input.UserServicePort;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    private final UserServicePort userService;
    private final UserMapper userMapper;

    @GetMapping("/info")
    public ResponseEntity<UserResponse> getInfo(Authentication authentication) {
        String username = authentication.getName();

        return ResponseEntity.ok().body(
            this.userMapper.toResponse(this.userService.getInfo(username))
        );
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok().body(
            this.userMapper.toResponse(this.userService.getAllUsers())       
        );
    }

    @PostMapping("/update")
    public ResponseEntity<UserResponse> update(Authentication authentication, @RequestBody @Valid UserRequest request) {
        
        UserModel userModel = this.userMapper.toModel(request);

        String username = authentication.getName();

        return ResponseEntity.ok().body(
            this.userMapper.toResponse(
                this.userService.updateInfo(username, userModel)
            )
        );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(Authentication authentication){

        String username = authentication.getName();

        this.userService.delete(username);

        return ResponseEntity.noContent().build();
    }
    
}
