package com.ubo.schoolregistrybackend.service.student;

import com.ubo.schoolregistrybackend.dto.student.StudentDto;
import com.ubo.schoolregistrybackend.dto.student.request.CreateStudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StudentService {

    StudentDto create(CreateStudentRequest request);

    List<StudentDto> getAll();

    StudentDto findById(UUID uuid);

    void delete(UUID id);

    StudentDto update(UUID id, CreateStudentRequest request);
}
