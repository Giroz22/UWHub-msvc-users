package com.waveghost.msvc_users_security.adapter.input.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.LoginRequest;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.RegisterRequest;
import com.waveghost.msvc_users_security.domain.model.UserModel;

@Mapper(componentModel = "spring")
public interface AuthApiMapper {
    
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "email", ignore = true),
        @Mapping(target = "name", ignore = true),
        @Mapping(target = "nickname", ignore = true),
        @Mapping(target = "roles", ignore = true)
    })
    UserModel requestToModel(LoginRequest request);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "nickname", ignore = true),
        @Mapping(target = "roles", ignore = true)
    })
    UserModel requestToModel(RegisterRequest request);
}
