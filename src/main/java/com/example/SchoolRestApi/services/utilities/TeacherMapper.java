package com.example.SchoolRestApi.services.utilities;


import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.repository.entity.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toTeacher(TeacherDTO teacherDTO);

    TeacherDTO toTeacherDTO(Teacher teacher);


}
