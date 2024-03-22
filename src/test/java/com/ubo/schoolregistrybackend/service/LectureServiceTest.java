package com.ubo.schoolregistrybackend.service;

import com.ubo.schoolregistrybackend.dto.converter.LectureDtoConverter;
import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
import com.ubo.schoolregistrybackend.dto.lecture.request.CreateLectureRequest;
import com.ubo.schoolregistrybackend.model.Lecture;
import com.ubo.schoolregistrybackend.repository.LectureRepository;
import com.ubo.schoolregistrybackend.service.lecture.LectureService;
import com.ubo.schoolregistrybackend.service.lecture.LectureServiceImpl;
import com.ubo.schoolregistrybackend.service.student.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LectureServiceTest {

    private LectureService lectureService;
    private LectureRepository lectureRepository;
    private StudentService studentService;
    private LectureDtoConverter lectureDtoConverter;

    @BeforeEach
    public void setUp() {
        lectureRepository = mock(LectureRepository.class);
        studentService = mock(StudentService.class);
        lectureDtoConverter = mock(LectureDtoConverter.class);
        lectureService = new LectureServiceImpl(lectureRepository, lectureDtoConverter, studentService);
    }

    @Test
    void testCreateLecture_shouldReturnLectureDto() {
        CreateLectureRequest request = new CreateLectureRequest("CS101", "Computer Science");

        Lecture lecture = new Lecture(UUID.randomUUID(),request.lectureCode(), request.lectureName());
        LectureDto lectureDto = new LectureDto(lecture.getLectureId(), lecture.getLectureCode(), lecture.getLectureName());
        when(lectureRepository.save(lecture)).thenReturn(lecture);
        when(lectureDtoConverter.convertLectureDto(lecture)).thenReturn(lectureDto);
        when(lectureService.create(request)).thenReturn(lectureDto);
    }

    @Test
    void testFindById_shouldReturnLectureDto() {
        UUID lectureId = UUID.randomUUID();
        Lecture lecture = new Lecture(lectureId, "CS101", "Computer Science");
        LectureDto lectureDto = new LectureDto(lecture.getLectureId(), lecture.getLectureCode(), lecture.getLectureName());
        when(lectureRepository.findById(lectureId)).thenReturn(java.util.Optional.of(lecture));
        when(lectureDtoConverter.convertLectureDto(lecture)).thenReturn(lectureDto);
        when(lectureService.findById(lectureId)).thenReturn(lectureDto);
    }

    @Test
    void testGetAllLecture_shouldReturnListOfLectureDto() {
        Lecture lecture = new Lecture(UUID.randomUUID(), "CS101", "Computer Science");
        List<Lecture> lectures = List.of(lecture);
        LectureDto lectureDto = new LectureDto(lecture.getLectureId(), lecture.getLectureCode(), lecture.getLectureName());
        when(lectureRepository.findAll()).thenReturn(lectures);
        when(lectureDtoConverter.convertLectureDtoList(lectures)).thenReturn(List.of(lectureDto));
        when(lectureService.getAllLecture()).thenReturn(List.of(lectureDto));
    }

    @Test
    void testFindLectureByLectureCode_shouldReturnLectureDto() {
        String lectureCode = "CS101";
        Lecture lecture = new Lecture(UUID.randomUUID(), "CS101", "Computer Science");
        LectureDto lectureDto = new LectureDto(lecture.getLectureId(), lecture.getLectureCode(), lecture.getLectureName());
        when(lectureRepository.findLectureByLectureCode(lectureCode)).thenReturn(java.util.Optional.of(lecture));
        when(lectureDtoConverter.convertLectureDto(lecture)).thenReturn(lectureDto);
        when(lectureService.findLectureByLectureCode(lectureCode)).thenReturn(lectureDto);
    }

    @Test
    void testDelete_shouldDeleteRelatedLecture() {
        UUID lectureId = UUID.randomUUID();
        Lecture lecture = new Lecture(lectureId, "CS101", "Computer Science");
        when(lectureRepository.findById(lectureId)).thenReturn(java.util.Optional.of(lecture));
        lectureService.delete(lectureId);
        when(lectureRepository.findById(lectureId)).thenReturn(java.util.Optional.empty());
    }
}
