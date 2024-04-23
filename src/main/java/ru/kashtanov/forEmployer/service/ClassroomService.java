package ru.kashtanov.forEmployer.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kashtanov.forEmployer.dto.ClassroomStudentDto;
import ru.kashtanov.forEmployer.dto.ClassroomTeacherDto;
import ru.kashtanov.forEmployer.model.Classroom;
import ru.kashtanov.forEmployer.model.Student;
import ru.kashtanov.forEmployer.model.Teacher;
import ru.kashtanov.forEmployer.repository.ClassroomRepository;
import ru.kashtanov.forEmployer.repository.StudentRepository;
import ru.kashtanov.forEmployer.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public ClassroomService(ClassroomRepository classroomRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.classroomRepository = classroomRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Classroom> getClassroomsList() {
        return classroomRepository.findAll();
    }

    public void addClassroomToDb(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    public void addStudentToClassroomList(ClassroomStudentDto classroomStudentDto) {
        Classroom classroom = classroomRepository.findById(classroomStudentDto.getClassroomId()).orElseThrow();
        Student student = studentRepository.findById(classroomStudentDto.getStudentId()).orElseThrow();
        classroom.getStudentList().add(student);
        classroomRepository.saveAndFlush(classroom);
    }

    public void assignTeacherForClassroom(ClassroomTeacherDto classroomTeacherDto) {
        Classroom classroom = classroomRepository.findById(classroomTeacherDto.getClassroomId()).orElseThrow();
        Teacher teacher = teacherRepository.findById(classroomTeacherDto.getTeacherId()).orElseThrow();
        classroom.setTeacher(teacher);
        classroomRepository.saveAndFlush(classroom);
    }

    public List<Classroom> getByFieldName(String fieldName) {
        return classroomRepository.findAll(Sort.by(fieldName));

    }

    public List<Classroom> getByFieldValue(List<Classroom> classrooms, Object fieldValue) {
        List<Classroom> foundClassrooms = new ArrayList<>();
        if (classrooms.getClass().getDeclaredFields().length != 0) {
            for (Classroom classroom : classrooms) {
                if (classroom.getMnemocode().equalsIgnoreCase(fieldValue.toString())) {
                    foundClassrooms.add(classroom);
                } else if (classroom.getTeacher().getFirstName().equalsIgnoreCase(fieldValue.toString())) {
                    foundClassrooms.add(classroom);
                }
                try {
                    if ((classroom.getYearOfStudy().equals(Integer.parseInt(fieldValue.toString())))) {
                        foundClassrooms.add(classroom);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("There is number format error");
                }
            }
        }
        return foundClassrooms;
    }

    public void deletingClassroom(Integer classroomId) {
        classroomRepository.deleteById(classroomId);
    }
}

