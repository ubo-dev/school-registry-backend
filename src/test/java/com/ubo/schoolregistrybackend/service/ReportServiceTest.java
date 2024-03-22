package com.ubo.schoolregistrybackend.service;

import com.ubo.schoolregistrybackend.dto.converter.LectureDtoConverter;
import com.ubo.schoolregistrybackend.dto.converter.StudentDtoConverter;
import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
import com.ubo.schoolregistrybackend.dto.student.StudentDto;
import com.ubo.schoolregistrybackend.model.Lecture;
import com.ubo.schoolregistrybackend.repository.LectureRepository;
import com.ubo.schoolregistrybackend.service.report.ReportService;
import com.ubo.schoolregistrybackend.service.report.ReportServiceImpl;
import com.ubo.schoolregistrybackend.service.student.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReportServiceTest {

    private ReportService reportService;
    private StudentService studentService;
    private LectureRepository lectureRepository;
    private StudentDtoConverter studentDtoConverter;
    private LectureDtoConverter lectureDtoConverter;

    @BeforeEach
    public void setUp() {
        studentService = mock(StudentService.class);
        lectureRepository = mock(LectureRepository.class);
        studentDtoConverter = mock(StudentDtoConverter.class);
        lectureDtoConverter = mock(LectureDtoConverter.class);
        reportService = new ReportServiceImpl(studentService, lectureRepository, studentDtoConverter, lectureDtoConverter);
    }


    @Test
    void testGetStudentsByLecture_shouldReturnListOfStudentDto() {
        UUID lectureId = UUID.randomUUID();
        Lecture lecture = new Lecture(lectureId, "CS101", "Computer Science");
        List<StudentDto> expectedStudentDtoList = List.of();
        when(lectureRepository.findById(lectureId)).thenReturn(java.util.Optional.of(lecture));
        when(studentDtoConverter.convertStudentDtoList(lecture.getStudents())).thenReturn(expectedStudentDtoList);

        List<StudentDto> actualStudentDtoList = reportService.getStudentsByLecture(lectureId);

        assertEquals(expectedStudentDtoList, actualStudentDtoList, "The returned list of students does not match the expected list.");
    }

    @Test
    void testGetStudentsWithNoLectures_shouldReturnListOfStudentDto() {
        List<StudentDto> expectedStudentDtoList = List.of();
        when(studentService.getAll()).thenReturn(expectedStudentDtoList);

        List<StudentDto> actualStudentDtoList = reportService.getStudentsWithNoLectures();

        assertEquals(expectedStudentDtoList, actualStudentDtoList, "The returned list of students with no lectures does not match the expected list.");
    }

    @Test
    void testGetLecturesWithNoStudents_shouldReturnListOfLectureDto() {
        List<LectureDto> expectedLectureDtoList = List.of();
        when(reportService.getLecturesWithNoStudents()).thenReturn(expectedLectureDtoList);

        List<LectureDto> actualLectureDtoList = reportService.getLecturesWithNoStudents();

        assertEquals(expectedLectureDtoList, actualLectureDtoList, "The returned list of lectures with no students does not match the expected list.");
    }






}
