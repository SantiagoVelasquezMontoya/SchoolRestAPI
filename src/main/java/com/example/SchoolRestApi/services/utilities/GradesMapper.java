package com.example.SchoolRestApi.services.utilities;

import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.example.SchoolRestApi.dto.GradesDTO;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.repository.entity.Grades;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GradesMapper {
    GradesDTO toGradesDTO(Grades graeds);
    Grades toGrades(GradesDTO gradesDTO);
}
