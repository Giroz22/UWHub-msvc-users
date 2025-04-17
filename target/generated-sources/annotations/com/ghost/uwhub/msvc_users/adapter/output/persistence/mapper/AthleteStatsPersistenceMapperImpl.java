package com.ghost.uwhub.msvc_users.adapter.output.persistence.mapper;

import com.ghost.uwhub.msvc_users.adapter.output.persistence.entity.AthleteStatsEntity;
import com.ghost.uwhub.msvc_users.domain.model.AthleteStats;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-16T22:36:12-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class AthleteStatsPersistenceMapperImpl implements AthleteStatsPersistenceMapper {

    @Override
    public AthleteStats AthleteStatsEntityToAthleteStats(AthleteStatsEntity AthleteStatsEntity) {
        if ( AthleteStatsEntity == null ) {
            return null;
        }

        AthleteStats.AthleteStatsBuilder athleteStats = AthleteStats.builder();

        athleteStats.id( AthleteStatsEntity.getId() );

        return athleteStats.build();
    }

    @Override
    public AthleteStatsEntity AthleteStatsEntityToAthleteStats(AthleteStats AthleteStats) {
        if ( AthleteStats == null ) {
            return null;
        }

        AthleteStatsEntity.AthleteStatsEntityBuilder athleteStatsEntity = AthleteStatsEntity.builder();

        athleteStatsEntity.id( AthleteStats.getId() );

        return athleteStatsEntity.build();
    }
}
