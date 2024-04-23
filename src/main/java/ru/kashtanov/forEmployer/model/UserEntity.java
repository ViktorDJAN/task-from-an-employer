package ru.kashtanov.forEmployer.model;

import jakarta.persistence.*;
import ru.kashtanov.forEmployer.someEnum.Gender;

import java.util.Objects;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity  {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String middleName;
    private String secondName;
    private Integer yearOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public UserEntity() {
    }



    public UserEntity(String firstName, String middleName, String secondName, Integer yearOfBirth, Gender gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName) && Objects.equals(secondName, that.secondName) && Objects.equals(yearOfBirth, that.yearOfBirth) && gender == that.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, middleName, secondName, yearOfBirth, gender);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender=" + gender +
                '}';
    }


}
