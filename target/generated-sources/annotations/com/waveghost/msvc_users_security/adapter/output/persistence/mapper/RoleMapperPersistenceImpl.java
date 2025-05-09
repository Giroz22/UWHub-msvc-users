package com.waveghost.msvc_users_security.adapter.output.persistence.mapper;

import com.waveghost.msvc_users_security.adapter.output.persistence.entity.RoleEntity;
import com.waveghost.msvc_users_security.domain.model.RoleModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-09T14:55:38-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class RoleMapperPersistenceImpl extends RoleMapperPersistence {

    @Override
    public RoleModel entityToModel(RoleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        RoleModel.RoleModelBuilder roleModel = RoleModel.builder();

        roleModel.id( entity.getId() );
        roleModel.userRole( entity.getUserRole() );

        return roleModel.build();
    }

    @Override
    public List<RoleModel> entityToModel(List<RoleEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<RoleModel> list = new ArrayList<RoleModel>( entity.size() );
        for ( RoleEntity roleEntity : entity ) {
            list.add( entityToModel( roleEntity ) );
        }

        return list;
    }
}
