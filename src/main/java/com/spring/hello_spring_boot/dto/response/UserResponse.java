package com.spring.hello_spring_boot.dto.response;

import java.time.LocalDate;
import java.util.Set;

import com.spring.hello_spring_boot.entity.Role;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String firstName;
    String lastName;
    LocalDate dob;
    Set<Role> roles;
}
