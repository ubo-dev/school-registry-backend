package com.ubo.schoolregistrybackend.repository;

import com.ubo.schoolregistrybackend.model.Lecture;
import com.ubo.schoolregistrybackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, UUID> {
    Optional<Lecture> findLectureByLectureCode(String lectureCode);
}
