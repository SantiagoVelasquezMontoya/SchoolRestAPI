package com.example.SchoolRestApi.repository.entity;


import com.example.SchoolRestApi.dto.AssignatureDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Assignature {

    @Id
    private Integer id;

    private String schedule;
    private String topic;

    @OneToMany
    private List<Alumn> alumns;


    @OneToOne
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
        this.alumns = assignatureDTO.getAlumns();
        this.teacher = assignatureDTO.getTeacher();
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
