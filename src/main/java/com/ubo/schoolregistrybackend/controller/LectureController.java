package com.ubo.schoolregistrybackend.controller;

import com.ubo.schoolregistrybackend.dto.lecture.LectureDto;
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
}