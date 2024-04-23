package ru.kashtanov.forEmployer.dto;

public class ClassroomStudentDto {
    private Integer classroomId;
    private Integer studentId;

    public ClassroomStudentDto(Integer classroomId, Integer studentId) {
        this.classroomId = classroomId;
        this.studentId = studentId;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "ClassroomStudentDto{" +
                "classroomId=" + classroomId +
                ", studentId=" + studentId +
                '}';
    }
}
