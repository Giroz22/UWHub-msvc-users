package com.waveghost.msvc_users_security.adapter.output.persistence.adapter;

import org.springframework.stereotype.Component;

import com.waveghost.msvc_users_security.adapter.output.persistence.entity.RoleEntity;
import com.waveghost.msvc_users_security.adapter.output.persistence.mapper.RoleMapperPersistence;
import com.waveghost.msvc_users_security.adapter.output.persistence.repository.RoleRepository;
import com.waveghost.msvc_users_security.domain.model.RoleModel;
import com.waveghost.msvc_users_security.domain.port.output.RolePersistencePort;
import com.waveghost.msvc_users_security.infrastructure.enums.UserRole;
import com.waveghost.msvc_users_security.infrastructure.exceptions.RoleNotFoundExeption;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RolePersistenceAdapter implements RolePersistencePort {

    private final RoleRepository roleRepository;
    private final RoleMapperPersistence roleMapper;

    @Override
    public RoleModel findByUserRole(UserRole role) {
        RoleEntity roleEntity = this.roleRepository.findByUserRole(role)
            .orElseThrow(()-> new RoleNotFoundExeption(role.name()));

        return this.roleMapper.entityToModel(roleEntity);
    }

}
