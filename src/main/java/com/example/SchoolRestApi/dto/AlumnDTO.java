package com.example.SchoolRestApi.dto;

import com.example.SchoolRestApi.repository.entity.Alumn;
import jakarta.persistence.criteria.CriteriaBuilder;

public class AlumnDTO {

    private Integer id;
    private String name;

    public AlumnDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public AlumnDTO(Alumn alumn) {
        this.id = alumn.getId();
        this.name = alumn.getName();
    }
    public AlumnDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
