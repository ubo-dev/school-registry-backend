package com.ubo.schoolregistrybackend.dto.student;

import java.util.UUID;

public record StudentDto(UUID studentId, String firstName, String lastName) {
    public StudentDto {
    }
}
