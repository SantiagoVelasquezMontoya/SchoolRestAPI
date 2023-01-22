package com.example.SchoolRestApi.services.implementation;

import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.repository.IAlumnRepository;
import com.example.SchoolRestApi.repository.IAssignatureRepository;
import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.services.IAlumnService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IAlumnServiceImpl implements IAlumnService {

    public final ToolService toolService;

    IAlumnRepository alumnRepository;
    IAssignatureRepository assignatureRepository;

    public IAlumnServiceImpl(ToolService toolService, IAlumnRepository alumnRepository, IAssignatureRepository assignatureRepository) {
        this.toolService = toolService;
        this.alumnRepository = alumnRepository;
        this.assignatureRepository = assignatureRepository;
    }

    @Override
    public String save(AlumnDTO alumn) {
        Optional<Alumn> testAlumni = alumnRepository.findById(alumn.getId());
        if(testAlumni.isPresent()){
            return "Alumni Already Exists";
        } else{
            if(!toolService.isFullNameValid(alumn.getFirstname() + alumn.getLastname())){
                return "Please enter a Valid Firstname and Lastname";
            }
//            if(!toolService.isValidDate(alumn.getBirthdate())){
//                return "no";
//            }
            alumn.setAge(toolService.getAgeFromBirthDate(alumn.getBirthdate()));
            alumnRepository.save(new Alumn(alumn));
            return "Alumni Successfully Saved";
        }
    }

    @Override
    public String update(AlumnDTO alumn) {
        Optional<Alumn> targetAlumn = alumnRepository.findById(alumn.getId());
        if(targetAlumn.isPresent()){
            if(!toolService.isFullNameValid(alumn.getFirstname() + alumn.getLastname())){
                return "Please enter a Valid Firstname and Lastname";
            }
            alumn.setAge(toolService.getAgeFromBirthDate(alumn.getBirthdate()));
            alumnRepository.save(new Alumn(alumn));
            return "Alumni was successfully Updated";
        } else{
            return "No Alumni was found";
        }
    }

    @Override
    public String delete(AlumnDTO alumn) {
        Optional<Alumn> targetAlumn = alumnRepository.findById(alumn.getId());
        if(targetAlumn.isPresent()){
            alumnRepository.deleteById(alumn.getId());
            return "Alumni was successfully deleted";
        } else{
            return "No Alumni was found";
        }
    }

    @Override
    public List<AlumnDTO> getAll() {
        List<Alumn> alumniList = (List<Alumn>) alumnRepository.findAll();
        return  alumniList
                .stream()
                .map(AlumnDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public String enroll(AlumnDTO alumn) {
        Optional<Alumn> targetAlumn = alumnRepository.findById(alumn.getId());

        if(targetAlumn.isPresent()){
            targetAlumn.get().setAssignature(alumn.getAssignature());
            alumnRepository.save(targetAlumn.get());
        }
        return "Alumn was successfully enrolled";
    }
}
