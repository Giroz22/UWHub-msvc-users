package com.waveghost.msvc_users_security.domain.port.output;

import java.util.List;

import com.waveghost.msvc_users_security.domain.model.UserModel;
import com.waveghost.msvc_users_security.domain.port.crud.CreatePort;

public interface UserPersistencePort extends CreatePort<UserModel>{
    UserModel findByEmail(String email);
    UserModel findByNickname(String nickname);
    UserModel findByEmailOrNickname(String emailOrNickname);
    
    boolean existByEmail(String email);
    boolean existByNickname(String nickname);
    boolean existByEmailOrNickname(String emailOrNickname);

    List<UserModel> getAllUsers();
    UserModel getInfo(String username);
    UserModel updateInfo(String username, UserModel modelUpdate);
    UserModel updatePassword(String username, String passwordUpdate);
    void delete(String username);
}
