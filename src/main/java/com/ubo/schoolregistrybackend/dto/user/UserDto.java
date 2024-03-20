package com.ubo.schoolregistrybackend.dto.user;

import com.ubo.schoolregistrybackend.model.Role;

public record UserDto(String firstName, String lastName, String email, String password, Role role) {
}
