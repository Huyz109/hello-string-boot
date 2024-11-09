package com.spring.hello_spring_boot.service;

import com.spring.hello_spring_boot.dto.request.AuthRequest;
import com.spring.hello_spring_boot.exception.AppException;
import com.spring.hello_spring_boot.exception.ErrorCode;
import com.spring.hello_spring_boot.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthService {
    UserRepository userRepository;

    public boolean authenticate(AuthRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                                 .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}