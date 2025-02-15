package com.spring.hello_spring_boot.dto.request;

import com.spring.hello_spring_boot.validator.DoBContraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String password;
    String firstName;
    String lastName;

    @DoBContraint(min = 5)
    LocalDate dob;
}
