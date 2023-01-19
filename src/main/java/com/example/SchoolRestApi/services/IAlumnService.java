package com.example.SchoolRestApi.services;

import com.example.SchoolRestApi.dto.AlumnDTO;

import java.util.List;

public interface IAlumnService {

    void save(AlumnDTO alumn);
    String update(AlumnDTO alumn);
    String delete(AlumnDTO alumn);
    List<AlumnDTO> getAll();

}
