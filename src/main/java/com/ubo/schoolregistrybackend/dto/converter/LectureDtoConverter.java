package com.ubo.schoolregistrybackend.dto.converter;

import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
import com.ubo.schoolregistrybackend.model.Lecture;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LectureDtoConverter {

    public LectureDto convertLectureDto(Lecture lecture) {
        return new LectureDto(
                lecture.getLectureId(),
                lecture.getLectureCode(),
                lecture.getLectureName()
        );
    }

    public List<LectureDto> convertLectureDtoList(List<Lecture> lectures) {
        return lectures.stream().map(this::convertLectureDto).toList();
    }
}
