package ru.kashtanov.forEmployer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import ru.kashtanov.forEmployer.someEnum.Gender;

@Entity
@Table
public class Student extends UserEntity {

    public Student() {
    }

    public Student(String firstName, String middleName, String secondName, Integer yearOfBirth, Gender gender) {
        super(firstName, middleName, secondName, yearOfBirth, gender);

    }


}