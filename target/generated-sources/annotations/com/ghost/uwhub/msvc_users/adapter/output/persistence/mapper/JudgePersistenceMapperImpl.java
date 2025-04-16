package com.ghost.uwhub.msvc_users.adapter.output.persistence.mapper;

import com.ghost.uwhub.msvc_users.adapter.output.persistence.entity.JudgeEntity;
import com.ghost.uwhub.msvc_users.domain.model.Judge;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-15T22:44:30-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class JudgePersistenceMapperImpl implements JudgePersistenceMapper {

    @Override
    public Judge JudgeEntityToJudge(JudgeEntity JudgeEntity) {
        if ( JudgeEntity == null ) {
            return null;
        }

        Judge.JudgeBuilder judge = Judge.builder();

        judge.id( JudgeEntity.getId() );

        return judge.build();
    }

    @Override
    public JudgeEntity JudgeEntityToJudge(Judge Judge) {
        if ( Judge == null ) {
            return null;
        }

        JudgeEntity.JudgeEntityBuilder judgeEntity = JudgeEntity.builder();

        judgeEntity.id( Judge.getId() );

        return judgeEntity.build();
    }
}
