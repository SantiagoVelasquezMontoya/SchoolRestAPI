package com.example.SchoolRestApi.repository.entity;


import com.example.SchoolRestApi.dto.AlumnDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alumn {

    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private String birthdate;
    private Integer age;


    public Alumn(Integer id, String firstname, String lastname, String birthdate, Integer age) {
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
