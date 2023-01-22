package com.example.SchoolRestApi.dto;

import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.repository.entity.Teacher;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherDTO {

    private Integer id;
    @NotBlank(message = "Firstname is required")
    @Pattern(regexp =  "[a-zA-Z]+" , message= "Only letters are valid")
    private String firstname;
    @NotBlank(message = "Lastname is required")
    @Pattern(regexp =  "[a-zA-Z]+" , message= "Only letters are valid")
    private String lastname;

    private Integer age;

    //private Assignature assignature;
    List<AssignatureDTO> assignature;

    public List<AssignatureDTO> getAssignature() {
        return assignature;
    }


    public void setAssignature(List<AssignatureDTO> assignature) {
        this.assignature = assignature;
    }

    public TeacherDTO(Integer id, String firstname, String lastname, Integer age, List<AssignatureDTO> assignature) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.assignature = assignature;
    }

    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.firstname = teacher.getFirstname();
        this.lastname = teacher.getLastname();
        this.age = teacher.getAge();
        if(teacher.getAssignature() != null){
            this.assignature = teacher.getAssignature().stream().map(AssignatureDTO::new).collect(Collectors.toList());
        } else{
            this.assignature= new ArrayList<>();
        }
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
