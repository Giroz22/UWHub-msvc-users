package com.ghost.uwhub.msvc_users.adapter.input.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ghost.uwhub.msvc_users.adapter.input.api.dto.request.UserLogin;
import com.ghost.uwhub.msvc_users.adapter.input.api.dto.request.UserRegister;
import com.ghost.uwhub.msvc_users.adapter.input.api.dto.request.UserRequest;
import com.ghost.uwhub.msvc_users.adapter.input.api.dto.response.UserResponse;
import com.ghost.uwhub.msvc_users.domain.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true )
    @Mapping(target = "athleteStats", ignore = true )
    @Mapping(target = "coach", ignore = true )
    @Mapping(target = "judge", ignore = true )
    @Mapping(target = "password", ignore = true )
    User requestToUser(UserRequest request);

    @Mapping(target = "id", ignore = true )
    @Mapping(target = "athleteStats", ignore = true )
    @Mapping(target = "coach", ignore = true )
    @Mapping(target = "judge", ignore = true )
    @Mapping(target = "dateOfBirth", ignore = true )
    @Mapping(target = "name", ignore = true )
    @Mapping(target = "lastname", ignore = true )
    @Mapping(target = "profilePictureUrl", ignore = true )
    User loginToUser(UserLogin userLogin);

    @Mapping(target = "id", ignore = true )
    @Mapping(target = "athleteStats", ignore = true )
    @Mapping(target = "coach", ignore = true )
    @Mapping(target = "judge", ignore = true )
    @Mapping(target = "dateOfBirth", ignore = true )
    @Mapping(target = "profilePictureUrl", ignore = true )
    User registerToUser(UserRegister userRegister);

    UserResponse userToResponse(User user);
    
    List<UserResponse> userToResponse(List<User> user);
}
