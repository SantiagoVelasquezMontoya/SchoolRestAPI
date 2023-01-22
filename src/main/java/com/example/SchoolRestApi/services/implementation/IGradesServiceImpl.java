package com.example.SchoolRestApi.services.implementation;


import com.example.SchoolRestApi.dto.GradesDTO;
import com.example.SchoolRestApi.repository.IAlumnRepository;
import com.example.SchoolRestApi.repository.IAssignatureRepository;
import com.example.SchoolRestApi.repository.IGradesRepository;
import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.repository.entity.Grades;
import com.example.SchoolRestApi.services.IGradesService;
import com.example.SchoolRestApi.services.utilities.GradesMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IGradesServiceImpl  implements IGradesService {

    private final IGradesRepository gradesRepository;

    private final IAlumnRepository alumnRepository;
    private final IAssignatureRepository assignatureRepository;

    private final GradesMapper gradesMapper;

    public IGradesServiceImpl(IGradesRepository gradesRepository, IAlumnRepository alumnRepository, IAssignatureRepository assignatureRepository, GradesMapper gradesMapper) {
        this.gradesRepository = gradesRepository;
        this.alumnRepository = alumnRepository;
        this.assignatureRepository = assignatureRepository;
        this.gradesMapper = gradesMapper;
    }

    @Override
    public String saveGrade(GradesDTO grades) {

        Optional<Grades> targetGrades = gradesRepository.findById(grades.getId());
        Optional<Alumn> targetAlumn = alumnRepository.findById(grades.getAlumn().getId());
        Optional<Assignature> targetAssignature = assignatureRepository.findById(grades.getAssignature().getId());
        //Optional<Alumn> targetAlumn = alumnRepository.findById(grades.getAlumn().getId());
//        Optional<Assignature> targetAssignature = assignatureRepository.findById(grades.getAssignature().getId());
        if(targetGrades.isPresent()) return "This grade already Exists";
        if(targetAlumn.isEmpty()) return "This Alumni does not exist";
        if(targetAssignature.isEmpty()) return "This Assignature does not exist";

//        Optional<Alumn> enrolledAlumn =  alumnRepository.findByAssignature_Id(targetAssignature.get().getId());
//        if(enrolledAlumn.isEmpty()) {
//            return "Alumn: " +  grades.getAlumn().getFirstname()
//                    +  " with Id:  " + grades.getAlumn().getId() + " " + "Is not Enrolled in this course";
//        }

        //targetAlumn.get().setGrades(new Grades(grades));
        //Alumn updatedAlumn = new Alumn();
       // updatedAlumn.setGrades(new Grades(grades));
       // alumnRepository.save(updatedAlumn);


       gradesRepository.save(new Grades(grades));
        return "Grades were saved successfully";
//        if(!targetAlumn.isPresent()){
//            return "Alumn: " +  grades.getAlumn().getFirstname()
//                    +  " with Id:  " + grades.getAlumn().getId() + " " + "Doesn't Exist";
//         }
//        if(!targetAssignature.isPresent()){
//            return "Assignature: " +  grades.getAssignature().getTopic()
//                    +  " with Id:  " + grades.getAssignature().getId() + " " + "Doesn't Exist";
//        }
//        Optional<Alumn> enrolledAlumn =  alumnRepository.findByAssignature_Id(targetAssignature.get().getId());
//        if(!enrolledAlumn.isPresent()) {
//            return "Alumn: " +  grades.getAlumn().getFirstname()
//                    +  " with Id:  " + grades.getAlumn().getId() + " " + "Is not Enrolled in this course";
//        }
//
//        gradesRepository.save(new Grades(grades));
//        return "The grading was successfully saved";
    }

    @Override
    public List<GradesDTO> getAllGrades() {
        List<Grades> gradesList = (List<Grades>) gradesRepository.findAll();
        return gradesList.stream().map(gradesMapper::toGradesDTO).collect(Collectors.toList());

    }

    @Override
    public String updateGrade(GradesDTO grades) {
        return null;
    }

    @Override
    public String deleteGrade(GradesDTO grades) {
        return null;
    }


    @Override
    public String createGrades(int id, int rating, int alumnid, int assignatureid) {
        System.out.println("Alumn Id: " + alumnid);
        Optional<Alumn> targetAlumn = alumnRepository.findById(alumnid);
        Optional<Assignature> targetAssignature = assignatureRepository.findById(assignatureid);

        if(targetAlumn.isEmpty()) return "No Alumn for that id";
        if(targetAssignature.isEmpty()) return "No Assignature for that id";

        Grades grades = new Grades();
        grades.setAlumn(targetAlumn.get());
        grades.setAssignature(targetAssignature.get());
        grades.setId(id);
        grades.setRating(rating);
        gradesRepository.save(grades);
        targetAlumn.get().setGrades(grades);
        alumnRepository.save(targetAlumn.get());

        return "Grades Were saved successfully";
    }
}
