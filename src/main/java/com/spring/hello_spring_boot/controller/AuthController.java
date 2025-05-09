package com.spring.hello_spring_boot.controller;

import java.text.ParseException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.JOSEException;
import com.spring.hello_spring_boot.dto.ApiResponse;
import com.spring.hello_spring_boot.dto.request.AuthRequest;
import com.spring.hello_spring_boot.dto.request.IntrospectRequest;
import com.spring.hello_spring_boot.dto.request.LogoutRequest;
import com.spring.hello_spring_boot.dto.request.RefreshRequest;
import com.spring.hello_spring_boot.dto.response.AuthResponse;
import com.spring.hello_spring_boot.dto.response.IntrospectResponse;
import com.spring.hello_spring_boot.service.AuthService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
    AuthService authService;

    @PostMapping("/login")
    ApiResponse<AuthResponse> login(@RequestBody AuthRequest request) {
        var result = authService.authenticate(request);
        return ApiResponse.<AuthResponse>builder().result(result).build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> verify(@RequestBody IntrospectRequest request)
            throws JOSEException, ParseException {
        var result = authService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder().result(result).build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authService.logout(request);
        return ApiResponse.<Void>builder().build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthResponse> verify(@RequestBody RefreshRequest request) throws JOSEException, ParseException {
        var result = authService.refreshToken(request);
        return ApiResponse.<AuthResponse>builder().result(result).build();
    }
}
