package com.example.SchoolRestApi.repository.entity;


import com.example.SchoolRestApi.dto.TeacherDTO;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity

public class Teacher {

    @Id
    private Integer id;

    private String firstname;
    private String lastname;
    private Integer age;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JsonIgnoreProperties("assignature")
    @JsonIgnore
    List<Assignature> assignature;

    public List<Assignature> getAssignature() {
        return assignature;
    }

    public void setAssignature(List<Assignature> assignature) {
        this.assignature = assignature;
    }

    public Teacher(Integer id, String firstname, String lastname, Integer age, List<Assignature> assignature) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.assignature = assignature;
    }

    public Teacher(TeacherDTO teacherDTO) {
        this.id = teacherDTO.getId();
        this.firstname = teacherDTO.getFirstname();
        this.lastname = teacherDTO.getLastname();
        this.age = teacherDTO.getAge();
        if(teacherDTO.getAssignature() != null){
            this.assignature = teacherDTO.getAssignature()
                    .stream().map(Assignature::new)
                    .collect(Collectors.toList());
        } else{
            this.assignature = new ArrayList<>();
        }
    }

    public Teacher() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
