package ru.kashtanov.forEmployer.dto;

public class ClassroomTeacherDto {
    private Integer classroomId;
    private Integer teacherId;

    public ClassroomTeacherDto(Integer classroomId, Integer teacherId) {
        this.classroomId = classroomId;
        this.teacherId = teacherId;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "ClassroomTeacherDto{" +
                "classroomId=" + classroomId +
                ", teacherId=" + teacherId +
                '}';
    }
}
