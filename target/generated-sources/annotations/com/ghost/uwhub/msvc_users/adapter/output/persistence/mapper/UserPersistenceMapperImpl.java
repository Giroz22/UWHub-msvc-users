package com.ghost.uwhub.msvc_users.adapter.output.persistence.mapper;

import com.ghost.uwhub.msvc_users.adapter.output.persistence.entity.UserEntity;
import com.ghost.uwhub.msvc_users.domain.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-17T09:05:59-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserPersistenceMapperImpl implements UserPersistenceMapper {

    @Autowired
    private AthleteStatsPersistenceMapper athleteStatsPersistenceMapper;
    @Autowired
    private CoachPersistenceMapper coachPersistenceMapper;
    @Autowired
    private JudgePersistenceMapper judgePersistenceMapper;

    @Override
    public UserEntity userToUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.athleteStats( athleteStatsPersistenceMapper.AthleteStatsEntityToAthleteStats( user.getAthleteStats() ) );
        userEntity.coach( coachPersistenceMapper.coachEntityToCoach( user.getCoach() ) );
        userEntity.dateOfBirth( user.getDateOfBirth() );
        userEntity.email( user.getEmail() );
        userEntity.id( user.getId() );
        userEntity.judge( judgePersistenceMapper.JudgeEntityToJudge( user.getJudge() ) );
        userEntity.lastname( user.getLastname() );
        userEntity.name( user.getName() );
        userEntity.password( user.getPassword() );
        userEntity.profilePictureUrl( user.getProfilePictureUrl() );

        return userEntity.build();
    }

    @Override
    public User userEntityToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.athleteStats( athleteStatsPersistenceMapper.AthleteStatsEntityToAthleteStats( userEntity.getAthleteStats() ) );
        user.coach( coachPersistenceMapper.coachEntityToCoach( userEntity.getCoach() ) );
        user.dateOfBirth( userEntity.getDateOfBirth() );
        user.email( userEntity.getEmail() );
        user.id( userEntity.getId() );
        user.judge( judgePersistenceMapper.JudgeEntityToJudge( userEntity.getJudge() ) );
        user.lastname( userEntity.getLastname() );
        user.name( userEntity.getName() );
        user.password( userEntity.getPassword() );
        user.profilePictureUrl( userEntity.getProfilePictureUrl() );

        return user.build();
    }

    @Override
    public List<User> userEntityToUser(List<UserEntity> usersEntity) {
        if ( usersEntity == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( usersEntity.size() );
        for ( UserEntity userEntity : usersEntity ) {
            list.add( userEntityToUser( userEntity ) );
        }

        return list;
    }

    @Override
    public void copyUserToUserEntity(User user, UserEntity userEntity) {
        if ( user == null ) {
            return;
        }

        if ( user.getAthleteStats() != null ) {
            userEntity.setAthleteStats( athleteStatsPersistenceMapper.AthleteStatsEntityToAthleteStats( user.getAthleteStats() ) );
        }
        if ( user.getCoach() != null ) {
            userEntity.setCoach( coachPersistenceMapper.coachEntityToCoach( user.getCoach() ) );
        }
        if ( user.getDateOfBirth() != null ) {
            userEntity.setDateOfBirth( user.getDateOfBirth() );
        }
        if ( user.getEmail() != null ) {
            userEntity.setEmail( user.getEmail() );
        }
        if ( user.getId() != null ) {
            userEntity.setId( user.getId() );
        }
        if ( user.getJudge() != null ) {
            userEntity.setJudge( judgePersistenceMapper.JudgeEntityToJudge( user.getJudge() ) );
        }
        if ( user.getLastname() != null ) {
            userEntity.setLastname( user.getLastname() );
        }
        if ( user.getName() != null ) {
            userEntity.setName( user.getName() );
        }
        if ( user.getPassword() != null ) {
            userEntity.setPassword( user.getPassword() );
        }
        if ( user.getProfilePictureUrl() != null ) {
            userEntity.setProfilePictureUrl( user.getProfilePictureUrl() );
        }
    }
}
