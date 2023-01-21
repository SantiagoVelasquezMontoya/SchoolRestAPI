package com.example.SchoolRestApi.services.implementation;

import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.repository.IAssignatureRepository;
import com.example.SchoolRestApi.repository.ITeacherRepository;
import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.repository.entity.Teacher;
import com.example.SchoolRestApi.services.IAssignatureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IAssignatureServiceImpl implements IAssignatureService {

    public final IAssignatureRepository assignatureRepository;
    public final ITeacherRepository teacherRepository;

    public IAssignatureServiceImpl(IAssignatureRepository assignatureRepository, ITeacherRepository teacherRepository) {
        this.assignatureRepository = assignatureRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public String saveAssignature(AssignatureDTO assignature) {

        Optional<Assignature> targetAssignature = assignatureRepository.findById(assignature.getId());
        if(targetAssignature.isPresent()){
            return "Assignature already Exists";
        } else {
            assignatureRepository.save(new Assignature(assignature));
            return "Assignature was Succesfully saved";
        }
    }

    @Override
    public String deleteAssignature(AssignatureDTO assignature) {
        Optional<Assignature> targetAssignature =  assignatureRepository.findById(assignature.getId());
            if(targetAssignature.isPresent()){
               // assignatureRepository.deleteById(assignature.getId());
                assignatureRepository.deleteById(1);
                return "Assignature succesfully deleted";
            }
            else{
                return "Assignature wasn't found";
            }
    }

    @Override
    public String updateAssignature(AssignatureDTO assignature) {
        Optional<Assignature> targetAssignature =  assignatureRepository.findById(assignature.getId());
        if(targetAssignature.isPresent()){
            assignatureRepository.save(new Assignature(assignature));
            return "Assignature succesfully updated";
        }
        else{
            return "Assignature wasn't found";
        }
    }

    @Override
    public List<AssignatureDTO> getAssignatures() {
        List<Assignature> assignatureList = (List<Assignature>) assignatureRepository.findAll();
        return assignatureList
                .stream()
                .map(AssignatureDTO::new)
                .collect(Collectors.toList());
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
