package com.example.SchoolRestApi.services.implementation;

import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.repository.IAlumnRepository;
import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.services.IAlumnService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IAlumnServiceImpl implements IAlumnService {

    IAlumnRepository alumnRepository;

    public IAlumnServiceImpl(IAlumnRepository alumnRepository) {
        this.alumnRepository = alumnRepository;
    }

    @Override
    public void save(AlumnDTO alumn) {
        alumnRepository.save(new Alumn(alumn));
    }

    @Override
    public String update(AlumnDTO alumn) {
        Optional<Alumn> targetAlumn = alumnRepository.findById(alumn.getId());
        if(targetAlumn.isPresent()){
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
}
