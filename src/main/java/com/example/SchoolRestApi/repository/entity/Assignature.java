package com.example.SchoolRestApi.repository.entity;


import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Assignature {

    @Id
    private Integer id;

    private String schedule;
    private String topic;

    @OneToMany(mappedBy = "assignature", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JsonIgnore
    private List<Alumn> alumns;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    @JsonIgnore
    private Teacher teacher;

    @OneToOne
    private Grades grades;

    public Assignature(Integer id, String schedule, String topic, List<Alumn> alumns, Teacher teacher, Grades grades) {
        this.id = id;
        this.schedule = schedule;
        this.topic = topic;
        this.alumns = alumns;
        this.teacher = teacher;
        this.grades = grades;
    }

    public Assignature(AssignatureDTO assignatureDTO) {
        this.id = assignatureDTO.getId();
        this.schedule = assignatureDTO.getSchedule();
        this.topic = assignatureDTO.getTopic();
        if(assignatureDTO.getAlumns() != null){
            this.alumns = assignatureDTO.getAlumns().stream().map(Alumn::new).collect(Collectors.toList());
        }
        this.teacher = new Teacher(assignatureDTO.getTeacher());
        this.grades = new Grades(assignatureDTO.getGrades());
    }

    public Assignature() {
    }

    public Assignature(Assignature assignature) {
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

    public List<Alumn> getAlumns() {
        return alumns;
    }

    public void setAlumns(List<Alumn> alumns) {
        this.alumns = alumns;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }
}
