package com.waveghost.msvc_users_security.adapter.output.persistence.mapper;

import com.waveghost.msvc_users_security.adapter.output.persistence.entity.RoleEntity;
import com.waveghost.msvc_users_security.adapter.output.persistence.entity.UserEntity;
import com.waveghost.msvc_users_security.domain.model.RoleModel;
import com.waveghost.msvc_users_security.domain.model.UserModel;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-09T14:55:38-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperPersistenceImpl implements UserMapperPersistence {

    @Autowired
    private RoleMapperPersistence roleMapperPersistence;

    @Override
    public UserEntity modelToEntity(UserModel model) {
        if ( model == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email( model.getEmail() );
        userEntity.id( model.getId() );
        userEntity.name( model.getName() );
        userEntity.nickname( model.getNickname() );
        userEntity.password( model.getPassword() );
        userEntity.roles( roleModelSetToRoleEntitySet( model.getRoles() ) );

        return userEntity.build();
    }

    @Override
    public UserModel entityToModel(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserModel.UserModelBuilder userModel = UserModel.builder();

        userModel.email( entity.getEmail() );
        userModel.id( entity.getId() );
        userModel.name( entity.getName() );
        userModel.nickname( entity.getNickname() );
        userModel.password( entity.getPassword() );
        userModel.roles( roleEntitySetToRoleModelSet( entity.getRoles() ) );

        return userModel.build();
    }

    @Override
    public List<UserModel> entityToModel(List<UserEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UserModel> list = new ArrayList<UserModel>( entity.size() );
        for ( UserEntity userEntity : entity ) {
            list.add( entityToModel( userEntity ) );
        }

        return list;
    }

    @Override
    public void CopyEntity(UserEntity source, UserEntity target) {
        if ( source == null ) {
            return;
        }

        if ( source.getEmail() != null ) {
            target.setEmail( source.getEmail() );
        }
        if ( source.getId() != null ) {
            target.setId( source.getId() );
        }
        if ( source.getName() != null ) {
            target.setName( source.getName() );
        }
        if ( source.getNickname() != null ) {
            target.setNickname( source.getNickname() );
        }
        if ( source.getPassword() != null ) {
            target.setPassword( source.getPassword() );
        }
        if ( target.getRoles() != null ) {
            Set<RoleEntity> set = source.getRoles();
            if ( set != null ) {
                target.getRoles().clear();
                target.getRoles().addAll( set );
            }
        }
        else {
            Set<RoleEntity> set = source.getRoles();
            if ( set != null ) {
                target.setRoles( new LinkedHashSet<RoleEntity>( set ) );
            }
        }
    }

    protected Set<RoleEntity> roleModelSetToRoleEntitySet(Set<RoleModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleEntity> set1 = new LinkedHashSet<RoleEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleModel roleModel : set ) {
            set1.add( roleMapperPersistence.modelToEntity( roleModel ) );
        }

        return set1;
    }

    protected Set<RoleModel> roleEntitySetToRoleModelSet(Set<RoleEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleModel> set1 = new LinkedHashSet<RoleModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleEntity roleEntity : set ) {
            set1.add( roleMapperPersistence.entityToModel( roleEntity ) );
        }

        return set1;
    }
}
