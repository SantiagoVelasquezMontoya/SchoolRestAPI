package com.example.SchoolRestApi.dto;

import com.example.SchoolRestApi.repository.entity.Alumn;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Date;

public class AlumnDTO {

    private Integer id;
    private String firstname;
    private String lastname;
    private String birthdate;
    private Integer age;


    public AlumnDTO(Integer id, String firstname, String lastname, String birthdate, Integer age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.age = age;
    }

    public AlumnDTO(Alumn alumn) {
        this.id = alumn.getId();
        this.firstname = alumn.getFirstname();
        this.lastname = alumn.getLastname();
        this.birthdate = alumn.getBirthdate();
        this.age = alumn.getAge();
    }
    public AlumnDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
