package com.ghost.uwhub.msvc_users.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghost.uwhub.msvc_users.domain.model.User;
import com.ghost.uwhub.msvc_users.domain.port.input.UserServicePort;
import com.ghost.uwhub.msvc_users.domain.port.output.UserPersistencePort;

@Service
public class UserService implements UserServicePort{

    @Autowired
    private UserPersistencePort persistence;

    public UserService(UserPersistencePort persistence) {
        this.persistence = persistence;
    }

    @Override
    public List<User> getAll() {
        return this.persistence.getAll();
    }

    @Override
    public User getById(String id) {
        return this.persistence.getById(id);
    }

    @Override
    public User update(String id, User entity) {
        return this.persistence.update(id, entity);
    }

    @Override
    public void delete(String id) {
        this.persistence.delete(id);        
    }

    @Override
    public User login(User user) {
        return this.persistence.getById(user.getId());
    }

    @Override
    public User register(User user) {
        return this.persistence.create(user);
    }
    
}
