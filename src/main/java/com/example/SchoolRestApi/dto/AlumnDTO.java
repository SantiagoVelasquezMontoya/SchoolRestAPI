package com.example.SchoolRestApi.dto;

import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Date;

public class AlumnDTO {

    private Integer id;
    @NotBlank(message="Firstname is Required")
    @Pattern(regexp =  "[a-zA-Z]+" , message= "Only letters are valid")
    private String firstname;
    @Pattern(regexp =  "[a-zA-Z]+" , message= "Only letters are valid")
    @NotBlank(message="Lastname is Required")
    private String lastname;
    @Pattern(regexp = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$" , message= "The only Valid date format is YYYY-MM-DD")
    @NotBlank(message = "Date of Birth is Required")
    private String birthdate;
    private Integer age;

    private Assignature assignature;



    public void setAssignature(Assignature assignature){
        this.assignature = assignature;
    }

    public Assignature getAssignature(){
        return this.assignature;
    }


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
        this.assignature = alumn.getAssignature();
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
