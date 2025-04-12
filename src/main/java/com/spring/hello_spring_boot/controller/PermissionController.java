package com.spring.hello_spring_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.spring.hello_spring_boot.dto.ApiResponse;
import com.spring.hello_spring_boot.dto.request.PermissionRequest;
import com.spring.hello_spring_boot.dto.response.PermissionResponse;
import com.spring.hello_spring_boot.service.PermissionService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    ApiResponse<PermissionResponse> createPermission(@RequestBody PermissionRequest request) {
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> findAllPermissions() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.findAll())
                .build();
    }

    @DeleteMapping("/{permission}")
    ApiResponse<Void> deletePermission(@PathVariable String permission) {
        permissionService.delete(permission);

        return ApiResponse.<Void>builder().build();
    }
}
