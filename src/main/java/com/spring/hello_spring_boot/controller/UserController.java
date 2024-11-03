package com.spring.hello_spring_boot.controller;

import com.spring.hello_spring_boot.dto.request.ApiResponse;
import com.spring.hello_spring_boot.dto.request.UserCreationRequest;
import com.spring.hello_spring_boot.dto.request.UserUpdateRequest;
import com.spring.hello_spring_boot.dto.response.UserResponse;
import com.spring.hello_spring_boot.entity.User;
import com.spring.hello_spring_boot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping("/list")
    ApiResponse<List<User>> getAllUsers(){
        ApiResponse<List<User>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getAllUsers());
        return apiResponse;
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUserById(@PathVariable("userId") String userId){
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getUserById(userId));
        return apiResponse;
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request){
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.updateUser(userId, request));
        return apiResponse;
    }

    @DeleteMapping("/{userId}")
    ApiResponse deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("User has been deleted");
        return apiResponse;
    }
}
