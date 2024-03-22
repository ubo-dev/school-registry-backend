# School Registry Backend
___
### Spring Boot

---
This project provides to create students and lectures, and allows users to manage the relationships.

### Endpoints

```html
POST /api/auth/logih -- usable for login as a user or admin
        admin credentials -> admin@gmail.com - passwd123*
        user credentials -> user@gmail.com - passwd123*

GET /api/lectures/getAll - retrieves all lectures
GET /api/lectures/getLectureById/{lectureId} - get lecture by id
GET /api/lectures/getLectureByCode/{lectureCode} - get lecture by lecture code
DELETE /api/lectures/deleteLectureById/{lectureId} - delete lecture by id
POST /api/lectures/createLecture - creates lecture
PUT /api/lectures/updateLecture/{id} - updates lecture by id
PUT /api/lectures/assignStudent/{studentId}/to/{lectureId}" - assign students to lectures by their id's

POST /api/students/createStudent - creates a new student
GET /api/students/findStudentById/{studentId} - retrieves a student
GET /api/students/getAll - retrieves all students
DELETE /api/students/deletStudent/{id} - deletes student by id
PUT /api/students/updateStudent/{id} - updates student by id

GET /api/reports/getStudentsByLecture/{lectureId} - get students who takes certain lecture
GET /api/reports/getLecturesByStudent/{studentId} - get lectures that are taken by certain student
GET /api/reports/getStudentsWithNoLectures - get students who didn't take any lectures
GET /api/reports/getLecturesWithNoStudents - get lectures that is not taken by any students

```

There are unit tests written for student, lecture and report services.

### Tech Stack

---
- Java 17
- Spring Boot
- Spring Data JPA
- Restful API
- Postgres
- Docker
- Docker compose
- JUnit

### Prerequisites

---
- Maven
- Docker

### Run & Build

---
There are 2 ways of run & build the application.

#### Docker Compose


You just need to run `docker-compose up` command
___
*$PORT: 8080*
```ssh
$ cd school-registry-backend
$ docker-compose up
```

#### Maven
___
*$PORT: 8080*
```ssh
$ cd school-registry-backend
$ mvn clean install
$ mvn spring-boot:run

```
