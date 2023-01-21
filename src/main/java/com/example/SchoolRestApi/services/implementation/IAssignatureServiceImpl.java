package com.example.SchoolRestApi.services.implementation;

import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.example.SchoolRestApi.repository.IAlumnRepository;
import com.example.SchoolRestApi.repository.IAssignatureRepository;
import com.example.SchoolRestApi.repository.ITeacherRepository;
import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.services.IAssignatureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IAssignatureServiceImpl implements IAssignatureService {

    public final IAssignatureRepository assignatureRepository;
    public final ITeacherRepository teacherRepository;
    public final IAlumnRepository alumnRepository;
    public final ToolService toolService;

    public IAssignatureServiceImpl(IAssignatureRepository assignatureRepository, ITeacherRepository teacherRepository, IAlumnRepository alumnRepository, ToolService toolService) {
        this.assignatureRepository = assignatureRepository;
        this.teacherRepository = teacherRepository;
        this.alumnRepository = alumnRepository;
        this.toolService = toolService;
    }

    @Override
    public String saveAssignature(AssignatureDTO assignature) {

        Optional<Assignature> targetAssignature = assignatureRepository.findById(assignature.getId());
        if(targetAssignature.isPresent()){
            return "Assignature already Exists";
        } else {
            if(!toolService.isAssignatureTopicValid(assignature.getTopic())) {
                return "Assignature Topic can only have Letters and Numbers with a maximum length of 200 characters";
            }
            assignatureRepository.save(new Assignature(assignature));
            return "Assignature was Succesfully saved";
        }
    }

    @Override
    public String deleteAssignature(AssignatureDTO assignature) {
        Optional<Assignature> targetAssignature =  assignatureRepository.findById(assignature.getId());
            if(targetAssignature.isPresent()){
                assignatureRepository.deleteById(assignature.getId());
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
            if(!toolService.isAssignatureTopicValid(assignature.getTopic())) {
                return "Assignature Topic can only have Letters and Numbers with a maximum length of 200 characters";
            }
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
    public List<AlumnDTO> getAssignatureAlumns(int assignatureId) {
//        List<Alumn> alumns = (List<Alumn>) alumnRepository.findAll();
//        return alumns.stream().filter((alumn) ->{
//            if(alumn.getAssignature() == null) return false;
//            return alumn.getAssignature().getId() == assignatureId;
//        }).map(AlumnDTO::new).collect(Collectors.toList());

        List<Alumn> alumnss = (List<Alumn>) alumnRepository.findAlumnByAssignatureId(assignatureId);
        return alumnss.stream().map(AlumnDTO::new).collect(Collectors.toList());
    }

    @Override
    public String deleteAlumn(AlumnDTO alumn) {
        return null;
    }
}
