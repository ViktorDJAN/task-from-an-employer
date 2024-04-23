package ru.kashtanov.forEmployer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kashtanov.forEmployer.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("SELECT t FROM Teacher t WHERE t.userId =?1")
    Teacher getTeachersByTeacherId(Integer teacherId);
}
