package ru.kashtanov.forEmployer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kashtanov.forEmployer.model.Classroom;


@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {
    @Query("SELECT c FROM Classroom c WHERE c.classroomId =?1")
    Classroom getClassroomsByClassroomId(Integer classroomId);
}
