package com.ghost.uwhub.msvc_users.adapter.output.persistence.mapper;

import com.ghost.uwhub.msvc_users.adapter.output.persistence.entity.CoachEntity;
import com.ghost.uwhub.msvc_users.domain.model.Coach;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-17T08:23:51-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class CoachPersistenceMapperImpl implements CoachPersistenceMapper {

    @Override
    public Coach coachEntityToCoach(CoachEntity coachEntity) {
        if ( coachEntity == null ) {
            return null;
        }

        Coach.CoachBuilder coach = Coach.builder();

        coach.id( coachEntity.getId() );

        return coach.build();
    }

    @Override
    public CoachEntity coachEntityToCoach(Coach coach) {
        if ( coach == null ) {
            return null;
        }

        CoachEntity.CoachEntityBuilder coachEntity = CoachEntity.builder();

        coachEntity.id( coach.getId() );

        return coachEntity.build();
    }
}
