package com.ubo.schoolregistrybackend.dto.converter;

import com.ubo.schoolregistrybackend.dto.student.StudentDto;
import com.ubo.schoolregistrybackend.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDtoConverter {

    public StudentDto convertStudentDto(Student student) {
        return new StudentDto(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName()
        );
    }

    public List<StudentDto> convertStudentDtoList(List<Student> studentList) {
        return studentList.stream().map(this::convertStudentDto).toList();
    }
}
