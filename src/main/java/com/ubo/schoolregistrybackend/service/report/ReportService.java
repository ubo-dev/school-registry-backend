package com.ubo.schoolregistrybackend.service.report;

import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
import com.ubo.schoolregistrybackend.dto.student.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ReportService {

    List<LectureDto> getLecturesByStudent(UUID studentId);

    List<StudentDto> getStudentsByLecture(UUID lectureId);

    List<StudentDto> getStudentsWithNoLectures();

    List<LectureDto> getLecturesWithNoStudents();
}
