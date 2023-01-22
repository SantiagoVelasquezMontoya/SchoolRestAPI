package com.example.SchoolRestApi.dto;

import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.repository.entity.Teacher;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.stream.Collectors;

public class AssignatureDTO {

    @Id
    private Integer id;

    @Pattern(regexp = "^(?=.{11,14}$)(([01][0-9]|2[0-3]):[0-5][0-9]-([01][0-9]|2[0-3]):[0-5][0-9])$",
            message= "The only Valid Time Format is HH:MM-HH:MM")
    @NotBlank(message = "Schedule is required")
    private String schedule;

    @Pattern(regexp = "^(?!.*true)[a-zA-Z0-9\\s]+$" , message= "Symbols or special characters are not allowed")
    @Pattern(regexp = "^.{3,200}$",  message = "The topic must have between 3 and 200 characters")
    @NotBlank(message = "Topic is required")
    private String topic;
    private List<AlumnDTO> alumns;
    private TeacherDTO teacher;

    private GradesDTO grades;

    public AssignatureDTO(Integer id, String schedule, String topic, List<AlumnDTO> alumns, TeacherDTO teacher, GradesDTO grades) {
        this.id = id;
        this.schedule = schedule;
        this.topic = topic;
        this.alumns = alumns;
        this.teacher = teacher;
        this.grades = grades;
    }

    public AssignatureDTO(Assignature assignature) {
        this.id = assignature.getId();
        this.schedule = assignature.getSchedule();
        this.topic = assignature.getTopic();
        if(assignature.getAlumns() != null){
            this.alumns = assignature.getAlumns().stream().map(AlumnDTO::new).collect(Collectors.toList());
        }
        this.teacher = new TeacherDTO(assignature.getTeacher());
        if(assignature.getGrades() != null){
            this.grades = new GradesDTO(assignature.getGrades());
        }
    }

    public AssignatureDTO() {
    }

    public GradesDTO getGrades() {
        return grades;
    }

    public void setGrades(GradesDTO grades) {
        this.grades = grades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<AlumnDTO> getAlumns() {
        return alumns;
    }

    public void addAlumn(AlumnDTO alumnDTO){
        this.alumns.add(alumnDTO);
    }

    public void setAlumns(List<AlumnDTO> alumns) {
        this.alumns = alumns;
    }


    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

}
