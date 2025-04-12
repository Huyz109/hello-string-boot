package com.spring.hello_spring_boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.hello_spring_boot.dto.request.PermissionRequest;
import com.spring.hello_spring_boot.dto.response.PermissionResponse;
import com.spring.hello_spring_boot.entity.Permission;
import com.spring.hello_spring_boot.mapper.PermissionMapper;
import com.spring.hello_spring_boot.repository.PermissionRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permissionRepository.save(permission);

        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> findAll() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).collect(Collectors.toList());
    }

    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}
