package com.example.SchoolRestApi.repository.entity;


import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Alumn {

    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private Integer age;


    @ManyToOne
    @JoinColumn(name = "assignature_id")
    @JsonBackReference
    private Assignature assignature;

    public Assignature getAssignature() {
        return assignature;
    }

    public void setAssignature(Assignature assignature) {
        this.assignature = assignature;
    }


    public Alumn(Integer id, String firstname, String lastname, LocalDate birthdate, Integer age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.age = age;
    }

    public Alumn(AlumnDTO alumnDTO) {
        this.id = alumnDTO.getId();
        this.firstname = alumnDTO.getFirstname();
        this.lastname = alumnDTO.getLastname();
        this.birthdate = alumnDTO.getBirthdate();
        this.age = alumnDTO.getAge();
        this.assignature = alumnDTO.getAssignature();
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
