package com.ghost.uwhub.msvc_users.adapter.input.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghost.uwhub.msvc_users.adapter.input.api.dto.request.UserLogin;
import com.ghost.uwhub.msvc_users.adapter.input.api.dto.request.UserRegister;
import com.ghost.uwhub.msvc_users.adapter.input.api.dto.request.UserRequest;
import com.ghost.uwhub.msvc_users.adapter.input.api.dto.response.UserResponse;
import com.ghost.uwhub.msvc_users.adapter.input.api.mapper.UserMapper;
import com.ghost.uwhub.msvc_users.domain.model.User;
import com.ghost.uwhub.msvc_users.domain.port.input.UserServicePort;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserServicePort userService;

    @Autowired
    private UserMapper mapper;

    public UserController(UserServicePort userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserRegister userRegister) {
        User newUser = this.userService.register(this.mapper.registerToUser(userRegister));
        return ResponseEntity.status(HttpStatus.CREATED).body(this.mapper.userToResponse(newUser));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody @Valid UserLogin userLogin) {
        User newUser = this.userService.login(this.mapper.loginToUser(userLogin));
        return ResponseEntity.status(HttpStatus.CREATED).body(this.mapper.userToResponse(newUser));
    }

    @GetMapping("")
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserResponse> users = this.mapper.userToResponse(this.userService.getAll());
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable String id) {
        User user = this.userService.getById(id);
        return ResponseEntity.ok().body(this.mapper.userToResponse(user));
    }  

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable String id, @RequestBody @Valid UserRequest userRequest) {
        User userUpdated = this.userService.update(id, this.mapper.requestToUser(userRequest));
        return ResponseEntity.ok().body(this.mapper.userToResponse(userUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }    
}
