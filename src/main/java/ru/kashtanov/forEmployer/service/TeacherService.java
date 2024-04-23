package ru.kashtanov.forEmployer.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kashtanov.forEmployer.someEnum.Gender;
import ru.kashtanov.forEmployer.model.Teacher;
import ru.kashtanov.forEmployer.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public List<Teacher> getTeachersList() {
        return teacherRepository.findAll();
    }

    public void addTeacherToDb(Teacher teacher) {
        teacherRepository.save(teacher);
    }


    public List<Teacher> getByFieldName(String fieldName) {
        return teacherRepository.findAll(Sort.by(fieldName));

    }

    public List<Teacher> getByFieldValue(List<Teacher> teachers, Object fieldValue) {
        List<Teacher>foundTeachers = new ArrayList<>();
        if(teachers.getClass().getDeclaredFields().length!=0){

            for(Teacher teacher:teachers){
                String gender = teacher.getGender().name();
                if(Gender.valueOf(gender).toString().equalsIgnoreCase(fieldValue.toString())){
                    foundTeachers.add(teacher);
                }
                else if(teacher.getFirstName().equalsIgnoreCase(fieldValue.toString())){
                    foundTeachers.add(teacher);
                }
                else if(teacher.getMiddleName().equalsIgnoreCase(fieldValue.toString())){
                    foundTeachers.add(teacher);
                }
                else if(teacher.getSecondName().equalsIgnoreCase(fieldValue.toString())){
                    foundTeachers.add(teacher);
                }
                try {
                    if((teacher.getYearOfBirth().equals(Integer.parseInt(fieldValue.toString())))){
                        foundTeachers.add(teacher);
                    }
                }catch (NumberFormatException e){
                    System.out.println("There is number format error");
                }
            }

        }return foundTeachers;

    }
    public void cloningTeacher(Integer teacherId) {
        Teacher teacher = teacherRepository.getTeachersByTeacherId(teacherId);
        Teacher copyTeacher = new Teacher(teacher.getFirstName(),
                teacher.getMiddleName(),teacher.getSecondName(),
                teacher.getYearOfBirth(),teacher.getGender(),teacher.getMainSubject());
        teacherRepository.save(copyTeacher);
    }

    public void deletingTeacher(Integer teacherId){
        teacherRepository.deleteById(teacherId);
    }
}


