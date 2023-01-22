package com.example.SchoolRestApi.services.utilities;

import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlumnMapper {

    Alumn toAlumn(AlumnDTO teacherDTO);

    AlumnDTO toAlumnDTO(Alumn alumn);
}
