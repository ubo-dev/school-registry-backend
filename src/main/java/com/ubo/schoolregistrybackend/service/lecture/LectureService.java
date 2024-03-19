package com.ubo.schoolregistrybackend.service.lecture;

import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface LectureService {

    LectureDto findById(UUID lectureId);

    List<LectureDto> getAllLecture();

    LectureDto findLectureByLectureCode(String lectureCode);
}