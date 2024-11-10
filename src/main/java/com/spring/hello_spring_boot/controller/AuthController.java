package com.spring.hello_spring_boot.controller;

import com.spring.hello_spring_boot.dto.request.ApiResponse;
import com.spring.hello_spring_boot.dto.request.AuthRequest;
import com.spring.hello_spring_boot.dto.response.AuthResponse;
import com.spring.hello_spring_boot.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
    AuthService authService;

    @PostMapping("/login")
    ApiResponse<AuthResponse> login(@RequestBody AuthRequest request) {
        boolean result = authService.authenticate(request);
        return ApiResponse.<AuthResponse>builder()
                .result(AuthResponse.builder()
                                    .isAuthenticated(result)
                                    .build())
                .build();
    }
}
