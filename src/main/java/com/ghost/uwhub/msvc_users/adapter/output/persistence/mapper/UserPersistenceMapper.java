package com.ghost.uwhub.msvc_users.adapter.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.ghost.uwhub.msvc_users.adapter.output.persistence.entity.UserEntity;
import com.ghost.uwhub.msvc_users.domain.model.User;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING, 
    uses = {
        AthleteStatsPersistenceMapper.class,
        CoachPersistenceMapper.class,
        JudgePersistenceMapper.class
    },
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserPersistenceMapper {
    UserEntity userToUserEntity(User user);
    User userEntityToUser(UserEntity userEntity);
    List<User> userEntityToUser(List<UserEntity> usersEntity);

    void copyUserToUserEntity(User user, @MappingTarget UserEntity userEntity);
}
