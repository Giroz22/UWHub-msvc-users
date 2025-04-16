package com.ghost.uwhub.msvc_users.adapter.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ghost.uwhub.msvc_users.adapter.output.persistence.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String>{
    
}
