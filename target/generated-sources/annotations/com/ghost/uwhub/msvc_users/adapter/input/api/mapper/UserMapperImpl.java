package com.ghost.uwhub.msvc_users.adapter.input.api.mapper;

import com.ghost.uwhub.msvc_users.adapter.input.api.dto.request.UserLogin;
import com.ghost.uwhub.msvc_users.adapter.input.api.dto.request.UserRegister;
import com.ghost.uwhub.msvc_users.adapter.input.api.dto.request.UserRequest;
import com.ghost.uwhub.msvc_users.adapter.input.api.dto.response.UserResponse;
import com.ghost.uwhub.msvc_users.domain.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-17T09:06:00-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User requestToUser(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.dateOfBirth( request.getDateOfBirth() );
        user.email( request.getEmail() );
        user.lastname( request.getLastname() );
        user.name( request.getName() );
        user.profilePictureUrl( request.getProfilePictureUrl() );

        return user.build();
    }

    @Override
    public User loginToUser(UserLogin userLogin) {
        if ( userLogin == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( userLogin.getEmail() );
        user.password( userLogin.getPassword() );

        return user.build();
    }

    @Override
    public User registerToUser(UserRegister userRegister) {
        if ( userRegister == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( userRegister.getEmail() );
        user.lastname( userRegister.getLastname() );
        user.name( userRegister.getName() );
        user.password( userRegister.getPassword() );

        return user.build();
    }

    @Override
    public UserResponse userToResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.dateOfBirth( user.getDateOfBirth() );
        userResponse.email( user.getEmail() );
        userResponse.id( user.getId() );
        userResponse.lastname( user.getLastname() );
        userResponse.name( user.getName() );
        userResponse.password( user.getPassword() );
        userResponse.profilePictureUrl( user.getProfilePictureUrl() );

        return userResponse.build();
    }

    @Override
    public List<UserResponse> userToResponse(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( user.size() );
        for ( User user1 : user ) {
            list.add( userToResponse( user1 ) );
        }

        return list;
    }
}
