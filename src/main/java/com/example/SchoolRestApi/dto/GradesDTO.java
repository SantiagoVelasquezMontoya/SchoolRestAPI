package com.example.SchoolRestApi.dto;

import com.example.SchoolRestApi.repository.entity.Grades;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;
import java.util.stream.Collectors;

public class GradesDTO {

    private Integer id;

    @Min(0)
    @Max(value = 5 , message="Maximum rating is 5")
    private Integer rating;
    private AlumnDTO alumn;
    private AssignatureDTO assignature;

    public GradesDTO(Integer id, Integer rating, AlumnDTO alumn, AssignatureDTO assignature) {
        this.id = id;
        this.rating = rating;
        this.alumn = alumn;
        this.assignature = assignature;
    }

    public GradesDTO(Grades grades) {
        this.id = grades.getId();
        this.rating = grades.getRating();
        if(grades.getAlumn() != null){
            this.alumn = new AlumnDTO(grades.getAlumn());
        }
         else{
             this.alumn = new AlumnDTO();
        }
        if(grades.getAssignature() != null){
            this.assignature = new AssignatureDTO(grades.getAssignature());
        }
    }


    public GradesDTO() {
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

    public AlumnDTO getAlumn() {
        return alumn;
    }

    public void setAlumn(AlumnDTO alumn) {
        this.alumn = alumn;
    }

    public AssignatureDTO getAssignature() {
        return assignature;
    }

    public void setAssignature(AssignatureDTO assignature) {
        this.assignature = assignature;
    }

    @Override
    public String toString() {
        return "gradesDTO{" +
                "id=" + id +
                ", rating=" + rating +
                ", alumn=" + alumn +
                ", assignature=" + assignature +
                '}';
    }
}
