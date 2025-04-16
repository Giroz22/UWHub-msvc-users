package com.ghost.uwhub.msvc_users.adapter.output.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ghost.uwhub.msvc_users.adapter.output.persistence.entity.AthleteStatsEntity;
import com.ghost.uwhub.msvc_users.domain.model.AthleteStats;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AthleteStatsPersistenceMapper {
    AthleteStats AthleteStatsEntityToAthleteStats(AthleteStatsEntity AthleteStatsEntity);

    @Mapping(target = "user", ignore = true )
    AthleteStatsEntity AthleteStatsEntityToAthleteStats(AthleteStats AthleteStats);
}
