package com.ubo.schoolregistrybackend.controller;

import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
import com.ubo.schoolregistrybackend.dto.student.StudentDto;
import com.ubo.schoolregistrybackend.service.report.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/reports")
@RestController
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/getStudentsByLecture/{lectureId}")
    public ResponseEntity<List<StudentDto>> getStudentsByLecture(@PathVariable String lectureId) {
        return ResponseEntity.ok(reportService.getStudentsByLecture(UUID.fromString(lectureId)));
    }

    @GetMapping("/getLecturesByStudent/{studentId}")
    public ResponseEntity<List<LectureDto>> getLecturesByStudents(@PathVariable String studentId) {
        return ResponseEntity.ok(reportService.getLecturesByStudent(UUID.fromString(studentId)));
    }

    @GetMapping("/getStudentsWithNoLectures")
    public ResponseEntity<List<StudentDto>> getStudentsWithNoLectures() {
        return ResponseEntity.ok(reportService.getStudentsWithNoLectures());
    }

    @GetMapping("/getLecturesWithNoStudents")
    public ResponseEntity<List<LectureDto>> getLecturesWithNoStudents() {
        return ResponseEntity.ok(reportService.getLecturesWithNoStudents());
    }
}
