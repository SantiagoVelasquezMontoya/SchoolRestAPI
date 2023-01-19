package com.example.SchoolRestApi.dto;

import com.example.SchoolRestApi.repository.entity.Teacher;

public class TeacherDTO {

    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;

    public TeacherDTO(Integer id, String firstname, String lastname, Integer age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.firstname = teacher.getFirstname();
        this.lastname = teacher.getLastname();
        this.age = teacher.getAge();
    }

    public TeacherDTO() {
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
