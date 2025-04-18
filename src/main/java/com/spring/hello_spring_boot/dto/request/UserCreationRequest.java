package com.spring.hello_spring_boot.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

import com.spring.hello_spring_boot.validator.DoBContraint;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 3, message = "Username must be at least 3 characters")
    String username;

    @Size(min = 8, message = "Password must be at least 8 characters")
    String password;

    String firstName;
    String lastName;

    @DoBContraint(min = 5, message = "INVALID_DOB")
    LocalDate dob;
}
