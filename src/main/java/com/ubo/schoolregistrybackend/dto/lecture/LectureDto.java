package com.ubo.schoolregistrybackend.dto.lecture;

import java.util.UUID;

public record LectureDto(UUID lectureId, String lectureCode, String lectureName) {
    public LectureDto{

    }
}