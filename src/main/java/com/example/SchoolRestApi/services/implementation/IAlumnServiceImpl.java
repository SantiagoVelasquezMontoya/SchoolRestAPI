package com.example.SchoolRestApi.services.implementation;

import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.repository.IAlumnRepository;
import com.example.SchoolRestApi.repository.IAssignatureRepository;
import com.example.SchoolRestApi.repository.ITeacherRepository;
import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.repository.entity.Teacher;
import com.example.SchoolRestApi.services.IAlumnService;
import com.example.SchoolRestApi.services.utilities.AlumnMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IAlumnServiceImpl implements IAlumnService {

    public final ToolService toolService;

    public final IAlumnRepository alumnRepository;
    public final IAssignatureRepository assignatureRepository;

    public final AlumnMapper alumnMapper;
    public final ITeacherRepository teacherRepository;

    public IAlumnServiceImpl(ToolService toolService, IAlumnRepository alumnRepository, IAssignatureRepository assignatureRepository, AlumnMapper alumnMapper, ITeacherRepository teacherRepository) {
        this.toolService = toolService;
        this.alumnRepository = alumnRepository;
        this.assignatureRepository = assignatureRepository;
        this.alumnMapper = alumnMapper;
        this.teacherRepository = teacherRepository;
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
                .map(alumnMapper::toAlumnDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String enroll(AlumnDTO alumn) {
        Optional<Alumn> targetAlumn = alumnRepository.findById(alumn.getId());
        Optional<Assignature> targetAssignature = assignatureRepository.findById(alumn.getAssignature().getId());
        Optional<Teacher> targetTeacher = teacherRepository.findById(targetAssignature.get().getTeacher().getId());
        if(targetAlumn.isPresent() && targetAssignature.isPresent() && targetTeacher.isPresent()) {
            targetAlumn.get().setAssignature(alumn.getAssignature());
            alumnRepository.save(targetAlumn.get());
            targetAssignature.get().setTeacher(targetTeacher.get());
            assignatureRepository.save(targetAssignature.get());
        }
        return "Alumni was successfully enrolled";
    }
}
