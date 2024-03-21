package com.ubo.schoolregistrybackend.dto.student;

import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;

import java.util.List;
import java.util.UUID;

public record StudentDto(UUID studentId, String firstName, String lastName, List<LectureDto> lectureSet) {
    public StudentDto {
    }
}
