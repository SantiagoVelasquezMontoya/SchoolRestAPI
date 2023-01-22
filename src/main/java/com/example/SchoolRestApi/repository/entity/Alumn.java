package com.example.SchoolRestApi.repository.entity;


import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public class Alumn {

    @Id
    private Integer id;
    private String firstname;

    private String lastname;
    private String birthdate;
    private Integer age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignature_id")
    @JsonBackReference
    @JsonIgnore
    private Assignature assignature;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private Grades grades;

    public Assignature getAssignature() {
        return assignature;
    }

    public void setAssignature(Assignature assignature) {
        this.assignature = assignature;
    }


    public Alumn(Integer id, String firstname, String lastname, String birthdate, Integer age, Grades grades, Assignature assignature) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.age = age;
        this.grades = grades;
        this.assignature = assignature;
    }

    public Alumn(AlumnDTO alumnDTO) {
        this.id = alumnDTO.getId();
        this.firstname = alumnDTO.getFirstname();
        this.lastname = alumnDTO.getLastname();
        this.birthdate = alumnDTO.getBirthdate();
        this.age = alumnDTO.getAge();
        if(alumnDTO.getGrades() != null){
            this.grades = alumnDTO.getGrades();
        }
        if(alumnDTO.getAssignature() != null){
            this.assignature = new Assignature(alumnDTO.getAssignature());
        }
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    public Alumn() {
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
