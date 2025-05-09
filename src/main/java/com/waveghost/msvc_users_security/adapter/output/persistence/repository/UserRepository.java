package com.waveghost.msvc_users_security.adapter.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waveghost.msvc_users_security.adapter.output.persistence.entity.UserEntity;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByNickname(String email);

    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
