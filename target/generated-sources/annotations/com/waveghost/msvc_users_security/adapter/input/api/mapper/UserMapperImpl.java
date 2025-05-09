package com.waveghost.msvc_users_security.adapter.input.api.mapper;

import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.UserRequest;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.response.UserResponse;
import com.waveghost.msvc_users_security.domain.model.UserModel;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toResponse(UserModel model) {
        if ( model == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.email( model.getEmail() );
        userResponse.name( model.getName() );
        userResponse.nickname( model.getNickname() );

        return userResponse.build();
    }

    @Override
    public List<UserResponse> toResponse(List<UserModel> model) {
        if ( model == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( model.size() );
        for ( UserModel userModel : model ) {
            list.add( toResponse( userModel ) );
        }

        return list;
    }

    @Override
    public UserModel toModel(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserModel.UserModelBuilder userModel = UserModel.builder();

        userModel.name( userRequest.getName() );
        userModel.nickname( userRequest.getNickname() );

        return userModel.build();
    }
}
