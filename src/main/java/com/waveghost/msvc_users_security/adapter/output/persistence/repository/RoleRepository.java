package com.waveghost.msvc_users_security.adapter.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waveghost.msvc_users_security.adapter.output.persistence.entity.RoleEntity;
import com.waveghost.msvc_users_security.infrastructure.enums.UserRole;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByUserRole(UserRole userRole);
}
