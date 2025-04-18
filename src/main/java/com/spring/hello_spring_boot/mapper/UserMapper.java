package com.spring.hello_spring_boot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.spring.hello_spring_boot.dto.request.UserCreationRequest;
import com.spring.hello_spring_boot.dto.request.UserUpdateRequest;
import com.spring.hello_spring_boot.dto.response.UserResponse;
import com.spring.hello_spring_boot.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
