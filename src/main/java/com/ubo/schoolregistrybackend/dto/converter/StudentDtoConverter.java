package com.ubo.schoolregistrybackend.dto.converter;

import com.ubo.schoolregistrybackend.dto.student.StudentDto;
import com.ubo.schoolregistrybackend.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentDtoConverter {

    private final LectureDtoConverter lectureDtoConverter;

    public StudentDtoConverter(LectureDtoConverter lectureDtoConverter) {
        this.lectureDtoConverter = lectureDtoConverter;
    }

    public StudentDto convertStudentDto(Student student) {
        return new StudentDto(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                lectureDtoConverter.convertLectureDtoList(student.getLectures() == null ? List.of() : student.getLectures())
        );
    }

    public List<StudentDto> convertStudentDtoList(List<Student> studentList) {
        return studentList.stream().map(this::convertStudentDto).toList();
    }
}
