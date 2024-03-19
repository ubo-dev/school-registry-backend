package com.ubo.schoolregistrybackend.service.lecture;

import com.ubo.schoolregistrybackend.dto.converter.LectureDtoConverter;
import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
import com.ubo.schoolregistrybackend.model.Lecture;
import com.ubo.schoolregistrybackend.repository.LectureRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final LectureDtoConverter lectureDtoConverter;

    public LectureServiceImpl(LectureRepository lectureRepository, LectureDtoConverter lectureDtoConverter) {
        this.lectureRepository = lectureRepository;
        this.lectureDtoConverter = lectureDtoConverter;
    }

    public LectureDto findById(UUID lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(
                        () -> new EntityNotFoundException("There is no lecture found with given id.")
                );

        return lectureDtoConverter.convertLectureDto(lecture);
    }

    public List<LectureDto> getAllLecture() {
        List<LectureDto> lectureDtoList = lectureDtoConverter.convertLectureDtoList(
                lectureRepository.findAll()
        );

        if (lectureDtoList.isEmpty())
            throw new EntityNotFoundException("There is no lecture found.");

        return lectureDtoList;
    }

    public LectureDto findLectureByLectureCode(String lectureCode) {
        Lecture lecture = lectureRepository.findLectureByLectureCode(lectureCode)
                .orElseThrow(
                        () -> new EntityNotFoundException("There is no lecture found with given code:" + lectureCode)
                );

        return lectureDtoConverter.convertLectureDto(lecture);
    }
}