package com.waveghost.msvc_users_security.adapter.input.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.UserRequest;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.response.UserResponse;
import com.waveghost.msvc_users_security.domain.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toResponse(UserModel model);
    List<UserResponse> toResponse(List<UserModel> model);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "password", ignore = true),
        @Mapping(target = "roles", ignore = true),
        @Mapping(target = "email", ignore = true),
    })
    UserModel toModel(UserRequest userRequest); 
}
