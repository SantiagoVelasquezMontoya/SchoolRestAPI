package com.example.SchoolRestApi.services.implementation;

import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.services.IAssignatureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAssignatureImpl implements IAssignatureService {

    @Override
    public String saveAssignature(AssignatureDTO assignature) {
        return null;
    }

    @Override
    public String deleteAssignature(AssignatureDTO assignature) {
        return null;
    }

    @Override
    public String updateAssignature(AssignatureDTO assignature) {
        return null;
    }

    @Override
    public List<AssignatureDTO> getAssignatures() {
        return null;
    }

    @Override
    public String saveTeacher(TeacherDTO teacher) {
        return null;
    }

    @Override
    public TeacherDTO getTeacher() {
        return null;
    }

    @Override
    public String deleteTeacher(TeacherDTO teacher) {
        return null;
    }

    @Override
    public String saveUser(AlumnDTO alumn) {
        return null;
    }

    @Override
    public List<AlumnDTO> getAlumns() {
        return null;
    }

    @Override
    public String deleteAlumn(AlumnDTO alumn) {
        return null;
    }
}
