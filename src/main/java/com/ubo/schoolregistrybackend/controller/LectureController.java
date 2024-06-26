package com.ubo.schoolregistrybackend.controller;

import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
import com.ubo.schoolregistrybackend.dto.lecture.request.CreateLectureRequest;
import com.ubo.schoolregistrybackend.service.lecture.LectureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LectureDto>> getAll() {
        return ResponseEntity.ok(lectureService.getAllLecture());
    }

    @GetMapping("/getLectureById/{lectureId}")
    public ResponseEntity<LectureDto> findById(@PathVariable UUID lectureId) {
        return ResponseEntity.ok(lectureService.findById(lectureId));
    }

    @GetMapping("/getLectureByCode/{lectureCode}")
    public ResponseEntity<LectureDto> findLectureByLectureCode(@PathVariable String lectureCode) {
        return ResponseEntity.ok(lectureService.findLectureByLectureCode(lectureCode));
    }

    @DeleteMapping("/deleteLecture/{id}")
    public ResponseEntity<String> deleteLecture(@PathVariable UUID id) {
        lectureService.delete(id);
        return ResponseEntity.ok("Lecture with id " + id + " has been deleted");
    }

    @PostMapping("/createLecture")
    public ResponseEntity<LectureDto> createLecture(@RequestBody CreateLectureRequest request) {
        return ResponseEntity.ok(lectureService.create(request));
    }

    @PutMapping("/updateLecture/{id}")
    public ResponseEntity<LectureDto> updateLecture(@PathVariable UUID id, @RequestBody CreateLectureRequest request) {
        return ResponseEntity.ok(lectureService.update(id, request));
    }

    @PutMapping("/assignStudent/{studentId}/to/{lectureId}")
    public ResponseEntity<LectureDto> assignStudentToLecture(@PathVariable String studentId, @PathVariable String lectureId) {
        return ResponseEntity.ok(lectureService.assignStudentToLecture(UUID.fromString(studentId), UUID.fromString(lectureId)));
    }
}