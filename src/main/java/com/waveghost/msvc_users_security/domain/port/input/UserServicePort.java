package com.waveghost.msvc_users_security.domain.port.input;

import java.util.List;

import com.waveghost.msvc_users_security.domain.model.UserModel;

public interface UserServicePort {
    List<UserModel> getAllUsers();
    UserModel getInfo(String username);
    UserModel updateInfo(String username, UserModel modelUpdate);
    void delete(String username);
}
