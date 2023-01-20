package com.example.SchoolRestApi.dto;

import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.repository.entity.Teacher;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

public class AssignatureDTO {

    @Id
    private Integer id;

    private String schedule;
    private String topic;

    private List<Alumn> alumns;


    private Teacher teacher;

    public AssignatureDTO(Integer id, String schedule, String topic, List<Alumn> alumns, Teacher teacher) {
        this.id = id;
        this.schedule = schedule;
        this.topic = topic;
        this.alumns = alumns;
        this.teacher = teacher;
    }

    public AssignatureDTO(Assignature assignature) {
        this.id = assignature.getId();
        this.schedule = assignature.getSchedule();
        this.topic = assignature.getTopic();
        this.alumns = assignature.getAlumns();
        this.teacher = assignature.getTeacher();
        //this.teacher = new TeacherDTO(assignature.getTeacher());
    }

    public AssignatureDTO() {
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

    public void addAlumn(AlumnDTO alumnDTO){
        this.alumns.add(new Alumn(alumnDTO));
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
