package com.waveghost.msvc_users_security.adapter.input.api.mapper;

import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.LoginRequest;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.RegisterRequest;
import com.waveghost.msvc_users_security.domain.model.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-09T14:55:38-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class AuthApiMapperImpl implements AuthApiMapper {

    @Override
    public UserModel requestToModel(LoginRequest request) {
        if ( request == null ) {
            return null;
        }

        UserModel.UserModelBuilder userModel = UserModel.builder();

        userModel.password( request.getPassword() );

        return userModel.build();
    }

    @Override
    public UserModel requestToModel(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        UserModel.UserModelBuilder userModel = UserModel.builder();

        userModel.email( request.getEmail() );
        userModel.name( request.getName() );
        userModel.password( request.getPassword() );

        return userModel.build();
    }
}
