package com.example.SchoolRestApi.services;

import com.example.SchoolRestApi.dto.TeacherDTO;

import java.util.List;

public interface ITeacherService {

    String save(TeacherDTO teacher);

    String update(TeacherDTO teacher);
    String delete(TeacherDTO teacher);
    List<TeacherDTO> getAll();
}
