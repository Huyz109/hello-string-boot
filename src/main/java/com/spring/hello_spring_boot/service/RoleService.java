package com.spring.hello_spring_boot.service;

import com.spring.hello_spring_boot.dto.request.RoleRequest;
import com.spring.hello_spring_boot.dto.response.RoleResponse;
import com.spring.hello_spring_boot.entity.Role;
import com.spring.hello_spring_boot.mapper.RoleMapper;
import com.spring.hello_spring_boot.repository.PermissionRepository;
import com.spring.hello_spring_boot.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;

    private final RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request) {
        Role role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toRoleResponse)
                .collect(Collectors.toList());
    }

    public void delete(String role) {
        roleRepository.deleteById(role);
    }
}
