package com.ubo.schoolregistrybackend.service.lecture;

import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
import com.ubo.schoolregistrybackend.dto.lecture.request.CreateLectureRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface LectureService {

    LectureDto create(CreateLectureRequest request);

    LectureDto findById(UUID lectureId);

    List<LectureDto> getAllLecture();

    LectureDto findLectureByLectureCode(String lectureCode);

    void delete(UUID lectureId);

    LectureDto update(UUID lectureId, CreateLectureRequest request);

    LectureDto assignStudentToLecture(UUID studentId, UUID lectureId);
}