package com.example.SchoolRestApi.services;

import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.example.SchoolRestApi.dto.TeacherDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.catalina.User;

import java.util.List;

public interface IAssignatureService {

    String saveAssignature(AssignatureDTO assignature);
    String deleteAssignature(AssignatureDTO assignature);
    String updateAssignature(AssignatureDTO assignature);
    List<AssignatureDTO> getAssignatures();
    List<AlumnDTO> getAssignatureAlumns(int assignatureId);


}
