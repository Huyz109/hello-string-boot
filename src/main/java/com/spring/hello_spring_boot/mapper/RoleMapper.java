package com.spring.hello_spring_boot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.hello_spring_boot.dto.request.RoleRequest;
import com.spring.hello_spring_boot.dto.response.RoleResponse;
import com.spring.hello_spring_boot.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
