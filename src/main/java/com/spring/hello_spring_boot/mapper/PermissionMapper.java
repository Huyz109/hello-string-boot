package com.spring.hello_spring_boot.mapper;

import com.spring.hello_spring_boot.dto.request.PermissionRequest;
import com.spring.hello_spring_boot.dto.response.PermissionResponse;
import com.spring.hello_spring_boot.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest permissionRequest);
    PermissionResponse toPermissionResponse(Permission permission);
}
