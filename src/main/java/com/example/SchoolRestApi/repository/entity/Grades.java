package com.example.SchoolRestApi.repository.entity;

import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.GradesDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Grades {

    @Id
    private Integer id;

    private Integer rating;

    //OneToOne Con alumno
    //ManytoOne con Asignatura

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="alumn_id",referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    @JsonIgnore
    private Alumn alumn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignature_id", insertable = false, updatable = false)
    @JsonBackReference
    @JsonIgnore
    private Assignature assignature;

    public Grades(Integer id, Integer rating, Alumn alumn, Assignature assignature) {
        this.id = id;
        this.rating = rating;
        this.alumn = alumn;
        this.assignature = assignature;
    }

    public Grades(GradesDTO gradesDTO) {
        this.id = gradesDTO.getId();
        this.rating = gradesDTO.getRating();
        if(gradesDTO.getAlumn() != null){
            this.alumn = gradesDTO.getAlumn();
        }
        if(gradesDTO.getAssignature() != null){
            this.assignature = new Assignature(gradesDTO.getAssignature());
        }
    }

    public Grades() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Alumn getAlumn() {
        return alumn;
    }

    public void setAlumn(Alumn alumn) {
        this.alumn = alumn;
    }

    public Assignature getAssignature() {
        return assignature;
    }

    public void setAssignature(Assignature assignature) {
        this.assignature = assignature;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", rating=" + rating +
                ", alumn=" + alumn +
                ", assignature=" + assignature +
                '}';
    }

}
