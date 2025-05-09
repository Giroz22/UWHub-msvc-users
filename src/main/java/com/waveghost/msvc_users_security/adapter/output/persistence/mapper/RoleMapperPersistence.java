package com.waveghost.msvc_users_security.adapter.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.waveghost.msvc_users_security.adapter.output.persistence.entity.RoleEntity;
import com.waveghost.msvc_users_security.adapter.output.persistence.repository.RoleRepository;
import com.waveghost.msvc_users_security.domain.model.RoleModel;
import com.waveghost.msvc_users_security.infrastructure.exceptions.RoleNotFoundExeption;

@Mapper(componentModel = "spring")
public abstract class RoleMapperPersistence {
    @Autowired
    private RoleRepository roleRepository;

    RoleEntity modelToEntity(RoleModel model){
        return this.roleRepository.findByUserRole(model.getUserRole())
        .orElseThrow(() -> new RoleNotFoundExeption(model.getUserRole().name())); 
    }

    public abstract RoleModel entityToModel(RoleEntity entity);
    public abstract List<RoleModel> entityToModel(List<RoleEntity> entity);
}
