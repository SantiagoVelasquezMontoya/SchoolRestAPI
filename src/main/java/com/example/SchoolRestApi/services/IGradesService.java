package com.example.SchoolRestApi.services;

import com.example.SchoolRestApi.dto.GradesDTO;

import java.util.List;

public interface IGradesService {

    public String saveGrade(GradesDTO grades);

    public String updateGrade(GradesDTO grades);

    public String deleteGrade(GradesDTO grades);

    List<GradesDTO>  getAllGrades();

}
