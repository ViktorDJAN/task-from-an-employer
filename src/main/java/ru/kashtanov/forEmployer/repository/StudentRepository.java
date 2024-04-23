package ru.kashtanov.forEmployer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kashtanov.forEmployer.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.userId =?1")
    Student getStudentsByStudentId(Integer studentId);


}
