package com.ghost.uwhub.msvc_users.adapter.output.persistence.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ghost.uwhub.msvc_users.adapter.output.persistence.entity.UserEntity;
import com.ghost.uwhub.msvc_users.adapter.output.persistence.mapper.UserPersistenceMapper;
import com.ghost.uwhub.msvc_users.adapter.output.persistence.repository.IUserRepository;
import com.ghost.uwhub.msvc_users.domain.model.User;
import com.ghost.uwhub.msvc_users.domain.port.output.UserPersistencePort;
import com.ghost.uwhub.msvc_users.infrastructure.exception.IdNotFoundException;

import jakarta.transaction.Transactional;

@Component
public class UserPersistenceAdapter implements UserPersistencePort {

    @Autowired
    private UserPersistenceMapper mapper;

    @Autowired
    private IUserRepository repository;

    public UserPersistenceAdapter(UserPersistenceMapper mapper, IUserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    @Transactional
    public User create(User user) {
        UserEntity userEntity = this.mapper.userToUserEntity(user);
        UserEntity userSaved = this.repository.save(userEntity);
        return this.mapper.userEntityToUser(userSaved);
    }

    @Override
    public List<User> getAll() {
        return this.mapper.userEntityToUser(this.repository.findAll());
    }

    @Override
    public User getById(String id) {
        return this.mapper.userEntityToUser(this.find(id));
    }

    @Override
    @Transactional
    public User update(String id, User user) {
        UserEntity userEntityDB = this.find(id);
        
        this.mapper.copyUserToUserEntity(user, userEntityDB);

        UserEntity userEntityUpdated = this.repository.save(userEntityDB);

        return this.mapper.userEntityToUser(userEntityUpdated);
    }

    @Override
    @Transactional
    public void delete(String id) {
        UserEntity userEntity = this.find(id);
        this.repository.delete(userEntity);
    }

    private UserEntity find(String id){
        UserEntity userEntity = this.repository.findById(id)
            .orElseThrow(() -> new IdNotFoundException("User"));

        return userEntity;
    }
    
}
