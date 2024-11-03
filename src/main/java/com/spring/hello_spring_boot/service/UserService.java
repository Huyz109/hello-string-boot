package com.spring.hello_spring_boot.service;

import com.spring.hello_spring_boot.dto.request.UserCreationRequest;
import com.spring.hello_spring_boot.dto.request.UserUpdateRequest;
import com.spring.hello_spring_boot.dto.response.UserResponse;
import com.spring.hello_spring_boot.entity.User;
import com.spring.hello_spring_boot.exception.AppException;
import com.spring.hello_spring_boot.exception.ErrorCode;
import com.spring.hello_spring_boot.mapper.UserMapper;
import com.spring.hello_spring_boot.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public User createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername((request.getUsername()))) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(request);

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                             .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
