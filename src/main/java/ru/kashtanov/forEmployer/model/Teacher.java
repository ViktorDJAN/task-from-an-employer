package ru.kashtanov.forEmployer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import ru.kashtanov.forEmployer.someEnum.Gender;

@Entity
@Table
public class Teacher extends UserEntity {
    private String mainSubject;

    public Teacher() {
    }

    public Teacher(String firstName, String middleName, String secondName, Integer yearOfBirth, Gender gender, String mainSubject) {
        super(firstName, middleName, secondName, yearOfBirth, gender);
        this.mainSubject = mainSubject;
    }

    public String getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

}
