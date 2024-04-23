package ru.kashtanov.forEmployer.controller;


import org.springframework.web.bind.annotation.*;
import ru.kashtanov.forEmployer.someEnum.Gender;
import ru.kashtanov.forEmployer.model.Student;
import ru.kashtanov.forEmployer.repository.StudentRepository;
import ru.kashtanov.forEmployer.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student_scope")
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;


    public StudentController(StudentService service, StudentRepository studentRepository) {
        this.studentService = service;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/one")
    public Student getOne() {
        ;
        return new Student("a", "bb", "ccc", 123, Gender.MALE);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        ;
        return studentService.getStudentsList();
    }

    @GetMapping("/sorting/{fieldName}")
    public List<Student> sortStudentsByField(@PathVariable("fieldName") String fieldName) {
        return (studentService.getByFieldName(fieldName));
    }

    @GetMapping("/choose/{anyValue}")
    public List<Student> getCertainStudent(@PathVariable("anyValue") String anyValue) {
        List<Student> list = studentRepository.findAll();
        return studentService.getByFieldValue(list, anyValue);
    }

    @PostMapping("/cloning")
    public String cloneStudentById(@RequestBody Student student) throws CloneNotSupportedException {
        studentService.cloningStudent(student.getUserId());
        return "Cloning is successfully completed";
    }


    @PostMapping("/creating")
    public String createNewStudent(@RequestBody Student student) {
        studentService.addStudentToDb(student);
        return "It is successfully added";
    }

    @PostMapping("/deleting")
    public String delete(@RequestBody Student student) {
        studentService.deletingStudent(student.getUserId());
        return "It is successfully deleted";
    }
}
