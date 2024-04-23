package ru.kashtanov.forEmployer.model;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table
public class Classroom {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;
    private String mnemocode;
    private Integer yearOfStudy;
    @OneToOne
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> studentList;

    public Classroom() {
    }

    public Classroom(String mnemocode, Integer yearOfStudy, Teacher teacher, List<Student> studentList) {
        this.mnemocode = mnemocode;
        this.yearOfStudy = yearOfStudy;
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getMnemocode() {
        return mnemocode;
    }

    public void setMnemocode(String mnemocode) {
        this.mnemocode = mnemocode;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId=" + classroomId +
                ", mnemocode='" + mnemocode + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", teacher=" + teacher +
                ", studentList=" + studentList +
                '}';
    }
}
