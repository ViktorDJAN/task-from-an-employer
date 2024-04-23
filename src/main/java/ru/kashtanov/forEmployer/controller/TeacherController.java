package ru.kashtanov.forEmployer.controller;

import org.springframework.web.bind.annotation.*;
import ru.kashtanov.forEmployer.someEnum.Gender;
import ru.kashtanov.forEmployer.model.Student;
import ru.kashtanov.forEmployer.model.Teacher;
import ru.kashtanov.forEmployer.repository.TeacherRepository;
import ru.kashtanov.forEmployer.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher_scope")
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherService service, TeacherRepository teacherRepository) {
        this.teacherService = service;
        this.teacherRepository = teacherRepository;
    }


    @GetMapping("/teachers")
    public List<Teacher> getAllStudents() {
        return teacherService.getTeachersList();
    }


    @GetMapping("/one")
    public Teacher getOneTeacher() {
        return new Teacher("John", "Richard", "Johnson", 234, Gender.MALE, "Math");
    }


    @GetMapping("/sorting/{fieldName}")
    public List<Teacher> sortStudentsByField(@PathVariable("fieldName") String fieldName) {
        return (teacherService.getByFieldName(fieldName));
    }


    @GetMapping("/choose/{anyValue}")
    public List<Teacher> getCertainStudent(@PathVariable("anyValue") String anyValue) {
        List<Teacher> list = teacherRepository.findAll();
        return teacherService.getByFieldValue(list, anyValue);
    }


    @PostMapping("/cloning")
    public String cloneStudentById(@RequestBody Student student) {
        teacherService.cloningTeacher(student.getUserId());
        return "Cloning is successfully completed";
    }


    @PostMapping("/creating")
    public String createNewStudent(@RequestBody Teacher teacher) {
        teacherService.addTeacherToDb(teacher);
        return "It is successfully added";
    }


    @PostMapping("/deleting")
    public String delete(@RequestBody Teacher teacher) {
        teacherService.deletingTeacher(teacher.getUserId());
        return "It is successfully deleted";
    }

}
