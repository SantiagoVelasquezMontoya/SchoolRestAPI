package com.example.SchoolRestApi.services.implementation;


import com.example.SchoolRestApi.dto.GradesDTO;
import com.example.SchoolRestApi.repository.IAlumnRepository;
import com.example.SchoolRestApi.repository.IAssignatureRepository;
import com.example.SchoolRestApi.repository.IGradesRepository;
import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.repository.entity.Grades;
import com.example.SchoolRestApi.services.IGradesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IGradesServiceImpl  implements IGradesService {

    private final IGradesRepository gradesRepository;

    private final IAlumnRepository alumnRepository;
    private final IAssignatureRepository assignatureRepository;

    public IGradesServiceImpl(IGradesRepository gradesRepository, IAlumnRepository alumnRepository, IAssignatureRepository assignatureRepository) {
        this.gradesRepository = gradesRepository;
        this.alumnRepository = alumnRepository;
        this.assignatureRepository = assignatureRepository;
    }

    @Override
    public String saveGrade(GradesDTO grades) {
        Optional<Grades> targetGrades = gradesRepository.findById(grades.getId());
        Optional<Alumn> targetAlumn = alumnRepository.findById(grades.getAlumn().getId());
        Optional<Assignature> targetAssignature = assignatureRepository.findById(grades.getAssignature().getId());
        if(targetGrades.isPresent()){
            return "This grade alreay Exists";
        }
        if(!targetAlumn.isPresent()){
            return "Alumn: " +  grades.getAlumn().getFirstname()
                    +  " with Id:  " + grades.getAlumn().getId() + " " + "Doesn't Exist";
         }
        if(!targetAssignature.isPresent()){
            return "Assignature: " +  grades.getAssignature().getTopic()
                    +  " with Id:  " + grades.getAssignature().getId() + " " + "Doesn't Exist";
        }
        Optional<Alumn> enrolledAlumn =  alumnRepository.findByAssignature_Id(targetAssignature.get().getId());
        if(!enrolledAlumn.isPresent()) {
            return "Alumn: " +  grades.getAlumn().getFirstname()
                    +  " with Id:  " + grades.getAlumn().getId() + " " + "Is not Enrolled in this course";
        }

        gradesRepository.save(new Grades(grades));
        return "The grading was successfully saved";
    }

    @Override
    public List<GradesDTO> getAllGrades() {
        List<Grades> gradesList = (List<Grades>) gradesRepository.findAll();
        return gradesList.stream().map(GradesDTO::new).collect(Collectors.toList());

    }

    @Override
    public String updateGrade(GradesDTO grades) {
        return null;
    }

    @Override
    public String deleteGrade(GradesDTO grades) {
        return null;
    }

}
