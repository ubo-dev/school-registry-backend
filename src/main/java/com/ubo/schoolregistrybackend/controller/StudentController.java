package com.ubo.schoolregistrybackend.controller;

import com.ubo.schoolregistrybackend.dto.student.StudentDto;
import com.ubo.schoolregistrybackend.dto.student.request.CreateStudentRequest;
import com.ubo.schoolregistrybackend.service.student.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentDtos = studentService.getAll();
        return ResponseEntity.ok(studentDtos);
    }
    public ResponseEntity<StudentDto> getStudentById(@PathVariable UUID id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping("/createStudent")
    public ResponseEntity<StudentDto> createStudent(@RequestBody CreateStudentRequest request) {
        return ResponseEntity.ok(studentService.create(request));
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable UUID id) {
        studentService.delete(id);
        return ResponseEntity.ok("Student with id " + id + " has been deleted");
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String id, @RequestBody CreateStudentRequest request) {
        return ResponseEntity.ok(studentService.update(UUID.fromString(id), request));
    }
}