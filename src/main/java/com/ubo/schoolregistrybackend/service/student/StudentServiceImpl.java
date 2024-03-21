package com.ubo.schoolregistrybackend.service.student;

import com.ubo.schoolregistrybackend.dto.converter.StudentDtoConverter;
import com.ubo.schoolregistrybackend.dto.student.StudentDto;
import com.ubo.schoolregistrybackend.dto.student.request.CreateStudentRequest;
import com.ubo.schoolregistrybackend.model.Student;
import com.ubo.schoolregistrybackend.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentDtoConverter studentDtoConverter;

    public StudentServiceImpl(StudentRepository studentRepository, StudentDtoConverter studentDtoConverter) {
        this.studentRepository = studentRepository;
        this.studentDtoConverter = studentDtoConverter;
    }

    public StudentDto create(CreateStudentRequest request) {

        Student student = new Student(
                request.firstName(),
                request.lastName()
        );

        return studentDtoConverter.convertStudentDto(studentRepository.save(student));
    }

    public List<StudentDto> getAll() {
        var students = studentRepository.findAll();

        if (students.isEmpty())
            throw new EntityNotFoundException("There is no student to show.");

        return studentDtoConverter.convertStudentDtoList(students);
    }


    public StudentDto findById(UUID uuid) {
        var student = studentRepository.findById(uuid).orElseThrow(
                () -> new EntityNotFoundException("There is no student found with given id")
        );

        return studentDtoConverter.convertStudentDto(student);
    }

    public void delete(UUID id) {
        studentRepository.deleteById(id);
    }

}