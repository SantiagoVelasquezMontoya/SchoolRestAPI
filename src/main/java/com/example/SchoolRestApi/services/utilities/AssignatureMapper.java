package com.example.SchoolRestApi.services.utilities;

import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.example.SchoolRestApi.repository.entity.Assignature;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AssignatureMapper {


    AssignatureDTO toAssignatureDTO(Assignature assignature);
    Assignature toAssignature(AssignatureDTO courseDTO);
}
