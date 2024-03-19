package com.ubo.schoolregistrybackend.dto.lecture.request;

import java.util.UUID;

public record CreateLectureRequest(UUID lectureId, String lectureCode, String lectureName) {
}
