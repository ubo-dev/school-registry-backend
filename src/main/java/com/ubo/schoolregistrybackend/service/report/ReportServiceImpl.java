package com.ubo.schoolregistrybackend.service.report;

import com.ubo.schoolregistrybackend.dto.converter.LectureDtoConverter;
import com.ubo.schoolregistrybackend.dto.converter.StudentDtoConverter;
import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
import com.ubo.schoolregistrybackend.dto.student.StudentDto;
import com.ubo.schoolregistrybackend.model.Lecture;
import com.ubo.schoolregistrybackend.repository.LectureRepository;
import com.ubo.schoolregistrybackend.service.lecture.LectureService;
import com.ubo.schoolregistrybackend.service.student.StudentService;
import java.util.Collections;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReportServiceImpl implements ReportService {

    private final StudentService studentService;

    private final LectureRepository lectureRepository;
    private final StudentDtoConverter studentDtoConverter;
    private final LectureDtoConverter lectureDtoConverter;

    public ReportServiceImpl(StudentService studentService, LectureRepository lectureRepository,
                             StudentDtoConverter studentDtoConverter, LectureDtoConverter lectureDtoConverter) {
        this.studentService = studentService;
        this.lectureRepository = lectureRepository;
        this.studentDtoConverter = studentDtoConverter;
        this.lectureDtoConverter = lectureDtoConverter;
    }

    public List<LectureDto> getLecturesByStudent(UUID studentId) {
        var student = studentService.findById(studentId);

        return student.lectureSet();
    }

    public List<StudentDto> getStudentsByLecture(UUID lectureId) {
        var lecture = lectureRepository.findById(lectureId).orElseThrow(
                () -> new RuntimeException("Lecture not found")
        );

        return studentDtoConverter.convertStudentDtoList(lecture.getStudents());
    }

    public List<StudentDto> getStudentsWithNoLectures() {
        var students = studentService.getAll();

        List<StudentDto> studentsNo = students.stream().filter(student -> student.lectureSet().isEmpty()).toList();

        if (studentsNo.isEmpty()) {
            return Collections.emptyList();
        } else {
            return studentsNo;
        }
    }

    public List<LectureDto> getLecturesWithNoStudents() {
        var lectures = lectureRepository.findAll();

        List<Lecture> lecturesNo = lectures.stream().filter(lecture -> lecture.getStudents().isEmpty()).toList();

        if (lecturesNo.isEmpty()) {
            return Collections.emptyList();
        } else {
            return lectureDtoConverter.convertLectureDtoList(lecturesNo);
        }
    }
}
