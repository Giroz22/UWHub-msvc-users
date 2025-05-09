package com.waveghost.msvc_users_security.adapter.output.persistence.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.waveghost.msvc_users_security.adapter.output.persistence.entity.UserEntity;
import com.waveghost.msvc_users_security.domain.model.UserModel;

@Mapper(
    componentModel = "spring",
    uses = {RoleMapperPersistence.class}
)
public interface UserMapperPersistence {
    UserEntity modelToEntity(UserModel model);    
    UserModel entityToModel(UserEntity entity);
    List<UserModel> entityToModel(List<UserEntity> entity);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void CopyEntity(UserEntity source, @MappingTarget UserEntity target);
}
