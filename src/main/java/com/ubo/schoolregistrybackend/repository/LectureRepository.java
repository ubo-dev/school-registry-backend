package com.ubo.schoolregistrybackend.repository;

import com.ubo.schoolregistrybackend.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, UUID> {
    Optional<Lecture> findLectureByLectureCode(String lectureCode);
}
