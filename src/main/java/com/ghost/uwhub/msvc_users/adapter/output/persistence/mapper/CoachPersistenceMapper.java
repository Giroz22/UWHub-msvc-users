package com.ghost.uwhub.msvc_users.adapter.output.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ghost.uwhub.msvc_users.adapter.output.persistence.entity.CoachEntity;
import com.ghost.uwhub.msvc_users.domain.model.Coach;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CoachPersistenceMapper {
    Coach coachEntityToCoach(CoachEntity coachEntity);

    @Mapping(target = "user", ignore = true )
    CoachEntity coachEntityToCoach(Coach coach);
}
