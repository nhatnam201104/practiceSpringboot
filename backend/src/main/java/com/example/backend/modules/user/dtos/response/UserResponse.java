package com.example.backend.modules.user.dtos.response;

import java.time.LocalDate;
import java.util.UUID;

import com.example.backend.modules.user.entity.Roles;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResponse {
    UUID userId;
    String fullName;
    String email;
    String password;
    LocalDate dob;
    String address;
    String avatar;
    Roles roles;

}
