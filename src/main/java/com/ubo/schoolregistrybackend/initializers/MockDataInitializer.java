package com.ubo.schoolregistrybackend.initializers;

import com.ubo.schoolregistrybackend.enums.RoleType;
import com.ubo.schoolregistrybackend.model.Lecture;
import com.ubo.schoolregistrybackend.model.Role;
import com.ubo.schoolregistrybackend.model.Student;
import com.ubo.schoolregistrybackend.model.User;
import com.ubo.schoolregistrybackend.repository.LectureRepository;
import com.ubo.schoolregistrybackend.repository.StudentRepository;
import com.ubo.schoolregistrybackend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class MockDataInitializer implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public MockDataInitializer(StudentRepository studentRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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


        List<Student> students = List.of(
                new Student(UUID.randomUUID(), "Mehmet", "Yılmaz", Set.of(chemistry, biology)),
                new Student(UUID.randomUUID(), "Ahmet", "Deniz", Set.of(history)),
                new Student(UUID.randomUUID(), "Ayşe", "Ermiş", Set.of(geography)),
                new Student(UUID.randomUUID(), "Fatma", "Bıçak", Set.of(math)),
                new Student(UUID.randomUUID(), "Ali", "Demirci", Set.of(physics)),
                new Student(UUID.randomUUID(), "Hasan", "Yıldız", Set.of(physics)),
                new Student(UUID.randomUUID(), "Hüseyin", "Kara", Set.of(music)),
                new Student(UUID.randomUUID(), "Mehmet", "Okur", Set.of(art)),
                new Student(UUID.randomUUID(), "Merve", "Duman", Set.of(literature))
        );

        studentRepository.saveAll(students);

        List<User> users = List.of(
                new User("adminFirstName", "adminLastName","admin@gmail.com", passwordEncoder.encode("passwd123*"), true, LocalDateTime.now(), new Role(RoleType.ADMIN)),
                new User("userFirstName", "userLastName","user@gmail.com",passwordEncoder.encode("passwd123*"), true, LocalDateTime.now(), new Role(RoleType.USER)
        ));


        userRepository.saveAll(users);
    }
}
