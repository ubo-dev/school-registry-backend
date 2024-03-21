package com.ubo.schoolregistrybackend.initializers;

import com.ubo.schoolregistrybackend.model.Lecture;
import com.ubo.schoolregistrybackend.model.Student;
import com.ubo.schoolregistrybackend.repository.LectureRepository;
import com.ubo.schoolregistrybackend.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class MockDataInitializer implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    public MockDataInitializer(StudentRepository studentRepository, LectureRepository lectureRepository) {
        this.studentRepository = studentRepository;
        this.lectureRepository = lectureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Lecture math = new Lecture(UUID.randomUUID(), "Math", "Mathematics");
        Lecture physics = new Lecture(UUID.randomUUID(), "Physics", "Physics");
        Lecture chemistry = new Lecture(UUID.randomUUID(), "Chemistry", "Chemistry");
        Lecture biology = new Lecture(UUID.randomUUID(), "Biology", "Biology");
        Lecture history = new Lecture(UUID.randomUUID(), "History", "History");
        Lecture geography = new Lecture(UUID.randomUUID(), "Geography", "Geography");
        Lecture literature = new Lecture(UUID.randomUUID(), "Literature", "Literature");
        Lecture music = new Lecture(UUID.randomUUID(), "Music", "Music");
        Lecture art = new Lecture(UUID.randomUUID(), "Art", "Art");

        //lectureRepository.saveAll(List.of(math, physics, chemistry, biology, history, geography, literature, music, art));


        List<Student> students = List.of(
                new Student(UUID.randomUUID(), "Mehmet", "Yılmaz", Set.of(chemistry, biology)),
                new Student(UUID.randomUUID(), "Ahmet", "Deniz", Set.of(history)),
                new Student(UUID.randomUUID(), "Ayşe", "Ermiş", Set.of(geography)),
                new Student(UUID.randomUUID(), "Fatma", "Bıçak", Set.of(math)),
                new Student(UUID.randomUUID(), "Ali", "Demirci", Set.of(physics)),
                new Student(UUID.randomUUID(), "Hasan", "Yıldız", Set.of(physics)),
                new Student(UUID.randomUUID(), "Hüseyin", "Kara", Set.of(music)),
                new Student(UUID.randomUUID(), "Mehmet", "Okur", Set.of(art))
        );

        studentRepository.saveAll(students);
    }
}
