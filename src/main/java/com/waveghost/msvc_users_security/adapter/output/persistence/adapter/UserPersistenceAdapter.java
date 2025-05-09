package com.waveghost.msvc_users_security.adapter.output.persistence.adapter;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.waveghost.msvc_users_security.adapter.output.persistence.entity.UserEntity;
import com.waveghost.msvc_users_security.adapter.output.persistence.mapper.UserMapperPersistence;
import com.waveghost.msvc_users_security.adapter.output.persistence.repository.UserRepository;
import com.waveghost.msvc_users_security.domain.model.UserModel;
import com.waveghost.msvc_users_security.domain.port.output.UserPersistencePort;
import com.waveghost.msvc_users_security.infrastructure.exceptions.EntityNotFoundExeption;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort{

    private final UserRepository userRepository;
    private final UserMapperPersistence userMapper;

    @Override
    @Transactional
    public UserModel create(UserModel model) {
        UserEntity user = this.userMapper.modelToEntity(model);

        UserEntity userSaved = this.userRepository.save(user);

        return this.userMapper.entityToModel(userSaved);
    }

    @Override
    public UserModel findByEmail(String email) {
        UserEntity user = this.userRepository.findByEmail(email)
            .orElseThrow(()-> new EntityNotFoundExeption("No se encontró un usuario con el correo: " + email));

        return this.userMapper.entityToModel(user);
    }

    @Override
    public UserModel findByNickname(String nickname) {
        UserEntity user = this.userRepository.findByNickname(nickname)
            .orElseThrow(()-> new EntityNotFoundExeption("No se encontró un usuario con el nickname: " + nickname));

        return this.userMapper.entityToModel(user);
    }

    @Override
    public UserModel findByEmailOrNickname(String emailOrUsername) {
        UserEntity user = this.userRepository.findByEmail(emailOrUsername).or(
            () -> this.userRepository.findByNickname(emailOrUsername)
        ).orElseThrow(
            () -> {
                return new UsernameNotFoundException("No se encontro el correo o el apodo: " + emailOrUsername);
            }
        );

        return this.userMapper.entityToModel(user);
    }

    @Override
    public boolean existByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public boolean existByNickname(String nickname) {
        return this.userRepository.existsByNickname(nickname);
    }

    @Override
    public boolean existByEmailOrNickname(String emailOrNickname) {
        return this.existByEmail(emailOrNickname) || this.existByNickname(emailOrNickname);
    }

    @Override
    public UserModel getInfo(String username) {
        return this.findByEmailOrNickname(username);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return this.userMapper.entityToModel(this.userRepository.findAll());
    }

    @Override
    public UserModel updateInfo(String username, UserModel modelUpdate) {
        UserEntity user = this.userMapper.modelToEntity(this.findByEmailOrNickname(username));
        UserEntity userUpdate = this.userMapper.modelToEntity(modelUpdate);

        this.userMapper.CopyEntity(user, userUpdate);

        return this.userMapper.entityToModel(
            this.userRepository.save(userUpdate)
        );
    }

    @Override
    public UserModel updatePassword(String username, String passwordUpdate) {
        UserEntity userEntity = this.userMapper.modelToEntity(this.findByEmailOrNickname(username));

        userEntity.setPassword(passwordUpdate);

        return this.userMapper.entityToModel(this.userRepository.save(userEntity));
    }

    @Override
    public void delete(String username) {
        UserEntity userEntity = this.userMapper.modelToEntity(this.findByEmailOrNickname(username));

        this.userRepository.delete(userEntity);
    }

}
