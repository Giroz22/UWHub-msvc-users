package com.waveghost.msvc_users_security.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.waveghost.msvc_users_security.domain.model.UserModel;
import com.waveghost.msvc_users_security.domain.port.input.UserServicePort;
import com.waveghost.msvc_users_security.domain.port.output.UserPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserServicePort{
    
    private final UserPersistencePort userPersistence;

    @Override
    public UserModel getInfo(String username) {
        return this.userPersistence.getInfo(username);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return this.userPersistence.getAllUsers();
    }

    @Override
    public UserModel updateInfo(String username, UserModel modelUpdate) {
        return this.userPersistence.updateInfo(username, modelUpdate);
    }

    @Override
    public void delete(String username) {
        this.userPersistence.delete(username);
    }
}
