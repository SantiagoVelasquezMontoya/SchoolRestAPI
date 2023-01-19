package com.example.SchoolRestApi.repository.entity;


import com.example.SchoolRestApi.dto.AlumnDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alumn {

    @Id
    private Integer id;
    private String name;


    public Alumn(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Alumn(AlumnDTO alumnDTO) {
        this.id = alumnDTO.getId();
        this.name = alumnDTO.getName();
    }

    public Alumn() {
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
