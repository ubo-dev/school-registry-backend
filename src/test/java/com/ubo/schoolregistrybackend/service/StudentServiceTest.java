package com.ubo.schoolregistrybackend.service;

import com.ubo.schoolregistrybackend.dto.converter.StudentDtoConverter;
import com.ubo.schoolregistrybackend.dto.student.StudentDto;
import com.ubo.schoolregistrybackend.dto.student.request.CreateStudentRequest;
import com.ubo.schoolregistrybackend.model.Student;
import com.ubo.schoolregistrybackend.repository.StudentRepository;
import com.ubo.schoolregistrybackend.service.student.StudentService;
import com.ubo.schoolregistrybackend.service.student.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudentServiceTest {

    private StudentService studentService;
    private StudentRepository studentRepository;
    private StudentDtoConverter studentDtoConverter;
    @BeforeEach
    public void setUp() {
        studentRepository = mock(StudentRepository.class);
        studentDtoConverter = mock(StudentDtoConverter.class);
        studentService = new StudentServiceImpl(studentRepository, studentDtoConverter);
    }

    @Test
    void testCreateStudent_shouldReturnStudentDto() {
        CreateStudentRequest request = new CreateStudentRequest("John", "Doe");

        Student student = new Student(UUID.randomUUID(), request.firstName(), request.lastName());
        StudentDto studentDto = new StudentDto(student.getStudentId(), student.getFirstName(), student.getLastName(), List.of());
        when(studentRepository.save(student)).thenReturn(student);
        when(studentDtoConverter.convertStudentDto(student)).thenReturn(studentDto);
        when(studentService.create(request)).thenReturn(studentDto);
    }

    @Test
    void testFindById_shouldReturnStudentDto() {
        UUID studentId = UUID.randomUUID();
        Student student = new Student(studentId, "John", "Doe");
        StudentDto studentDto = new StudentDto(student.getStudentId(), student.getFirstName(), student.getLastName(), List.of());
        when(studentRepository.findById(studentId)).thenReturn(java.util.Optional.of(student));
        when(studentDtoConverter.convertStudentDto(student)).thenReturn(studentDto);
        when(studentService.findById(studentId)).thenReturn(studentDto);
    }

    @Test
    void testGetAll_shouldReturnListOfStudentDto() {
        Student student = new Student(UUID.randomUUID(), "John", "Doe");
        List<Student> students = List.of(student);
        StudentDto studentDto = new StudentDto(student.getStudentId(), student.getFirstName(), student.getLastName(), List.of());
        when(studentRepository.findAll()).thenReturn(students);
        when(studentDtoConverter.convertStudentDtoList(students)).thenReturn(List.of(studentDto));
        when(studentService.getAll()).thenReturn(List.of(studentDto));
    }

    @Test
    void testDelete_shouldDeleteStudent() {
        UUID lectureId = UUID.randomUUID();
        Student student = new Student(lectureId, "John", "Doe");
        when(studentRepository.findById(lectureId)).thenReturn(java.util.Optional.of(student));
        studentService.delete(lectureId);
        when(studentRepository.findById(lectureId)).thenReturn(java.util.Optional.empty());
    }
}
