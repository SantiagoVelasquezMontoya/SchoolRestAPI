package com.example.SchoolRestApi.repository.entity;


import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private List<Alumn> alumns;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    private Teacher teacher;

    public Assignature(Integer id, String schedule, String topic, List<Alumn> alumns, Teacher teacher) {
        this.id = id;
        this.schedule = schedule;
        this.topic = topic;
        this.alumns = alumns;
        this.teacher = teacher;
    }

    public Assignature(AssignatureDTO assignatureDTO) {
        this.id = assignatureDTO.getId();
        this.schedule = assignatureDTO.getSchedule();
        this.topic = assignatureDTO.getTopic();
        //this.alumns = assignatureDTO.getAlumns();
        if(assignatureDTO.getAlumns() != null){
            this.alumns = assignatureDTO.getAlumns().stream().map(Alumn::new).collect(Collectors.toList());
        }
        this.teacher = new Teacher(assignatureDTO.getTeacher());
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
}
