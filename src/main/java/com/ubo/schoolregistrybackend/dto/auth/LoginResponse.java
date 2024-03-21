package com.ubo.schoolregistrybackend.dto.auth;

import com.ubo.schoolregistrybackend.dto.user.UserDto;

public record LoginResponse(UserDto userDto) {
}
