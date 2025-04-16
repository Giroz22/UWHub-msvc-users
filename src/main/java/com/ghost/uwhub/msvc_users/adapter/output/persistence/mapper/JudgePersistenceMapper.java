package com.ghost.uwhub.msvc_users.adapter.output.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ghost.uwhub.msvc_users.adapter.output.persistence.entity.JudgeEntity;
import com.ghost.uwhub.msvc_users.domain.model.Judge;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface JudgePersistenceMapper {
    Judge JudgeEntityToJudge(JudgeEntity JudgeEntity);
    
    @Mapping(target = "user", ignore = true )
    JudgeEntity JudgeEntityToJudge(Judge Judge);
}
