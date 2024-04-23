package ru.kashtanov.forEmployer.service;


import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ru.kashtanov.forEmployer.someEnum.Gender;
import ru.kashtanov.forEmployer.model.Student;
import ru.kashtanov.forEmployer.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentsList() {
        return studentRepository.findAll();
    }

    public void addStudentToDb(Student student) {
        studentRepository.save(student);
    }


    public List<Student> getByFieldName(String fieldName) {
        return studentRepository.findAll(Sort.by(fieldName));

    }

    public List<Student> getByFieldValue(List<Student> students, Object fieldValue) {
        List<Student>foundStudents = new ArrayList<>();
        if(students.getClass().getDeclaredFields().length!=0){
            for(Student student:students){
                  String gender = student.getGender().name();
               if(Gender.valueOf(gender).toString().equalsIgnoreCase(fieldValue.toString())){
                    foundStudents.add(student);
                }
                else if(student.getFirstName().equalsIgnoreCase(fieldValue.toString())){
                    foundStudents.add(student);
                }
                else if(student.getMiddleName().equalsIgnoreCase(fieldValue.toString())){
                    foundStudents.add(student);
                }
                else if(student.getSecondName().equalsIgnoreCase(fieldValue.toString())){
                    foundStudents.add(student);
                }
                try {
                    if((student.getYearOfBirth().equals(Integer.parseInt(fieldValue.toString())))){
                        foundStudents.add(student);
                    }
                }catch (NumberFormatException e){
                    System.out.println("There is number format error");
                }
            }
        }return foundStudents;
    }

    public void cloningStudent(Integer studentId) {
        Student student = studentRepository.getStudentsByStudentId(studentId);
        Student copyStudent = new Student(student.getFirstName(),
                student.getMiddleName(),student.getSecondName(),
                student.getYearOfBirth(),student.getGender());
        studentRepository.save(copyStudent);
    }

    public void deletingStudent(Integer studentId){
       studentRepository.deleteById(studentId);
    }
}
