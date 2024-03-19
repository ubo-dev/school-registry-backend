package com.ubo.schoolregistrybackend.model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID lectureId;

    private String lectureCode;

    private String lectureName;

    @ManyToMany
    @JoinTable(
            name = "student_lecture",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id")
    )
    Set<Student> students;

    public Lecture() {

    }

    public Lecture(UUID lectureId, String lectureCode, String lectureName, Set<Student> students) {
        this.lectureId = lectureId;
        this.lectureCode = lectureCode;
        this.lectureName = lectureName;
        this.students = students;
    }

    public UUID getLectureId() {
        return lectureId;
    }

    public void setLectureId(UUID lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureCode() {
        return lectureCode;
    }

    public void setLectureCode(String lectureCode) {
        this.lectureCode = lectureCode;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

}