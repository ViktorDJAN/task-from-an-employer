package ru.kashtanov.forEmployer.controller;


import org.springframework.web.bind.annotation.*;
import ru.kashtanov.forEmployer.dto.ClassroomStudentDto;
import ru.kashtanov.forEmployer.dto.ClassroomTeacherDto;
import ru.kashtanov.forEmployer.model.Classroom;
import ru.kashtanov.forEmployer.repository.ClassroomRepository;
import ru.kashtanov.forEmployer.service.ClassroomService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classroom_scope")
public class ClassroomController {
    private final ClassroomService classroomService;
    private final ClassroomRepository classroomRepository;

    public ClassroomController(ClassroomService classroomService, ClassroomRepository classroomRepository) {
        this.classroomService = classroomService;
        this.classroomRepository = classroomRepository;
    }

    @GetMapping("/one")
    public ClassroomStudentDto getOneClassroom() {
        ClassroomStudentDto dto = new ClassroomStudentDto(1, 4);
        return dto;
    }

    @GetMapping("/classrooms")
    public List<Classroom> getAllClassrooms() {
        return classroomService.getClassroomsList();
    }

    @GetMapping("/sorting/{fieldName}")
    public List<Classroom> sortClassroomsByField(@PathVariable("fieldName") String fieldName) {
        return (classroomService.getByFieldName(fieldName));
    }

    @GetMapping("/choose/{anyValue}")
    public List<Classroom> getCertainClassroom(@PathVariable("anyValue") String anyValue) {
        List<Classroom> list = classroomRepository.findAll();
        return classroomService.getByFieldValue(list, anyValue);
    }


    @PostMapping("/creating")
    public String createNewClassroom(@RequestBody Classroom classroom) {
        classroomService.addClassroomToDb(classroom);
        return "It is successfully added";
    }

    @PostMapping("/addingStudentToClassRoom")
    public String addingStudentToClassroomList(@RequestBody ClassroomStudentDto dto) {
        classroomService.addStudentToClassroomList(dto);
        return "Student is successfully added to the classroom";
    }

    @PostMapping("/assigningTeacherToClassRoom")
    public String assigningStudentForClassroom(@RequestBody ClassroomTeacherDto dto) {
        classroomService.assignTeacherForClassroom(dto);
        return "Teacher is successfully appointed for the classroom";
    }

    @PostMapping("/deleting")
    public String delete(@RequestBody Classroom classroom) {
        classroomService.deletingClassroom(classroom.getClassroomId());
        return "It is successfully deleted";
    }
}

