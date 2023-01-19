package com.example.SchoolRestApi.services.implementation;

import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.repository.ITeacherRepository;
import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Teacher;
import com.example.SchoolRestApi.services.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ITeacherImpl implements ITeacherService {


    public final ITeacherRepository teacherRepository;

    public ITeacherImpl(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public String save(TeacherDTO teacher) {
        Optional<Teacher> testTeacher = teacherRepository.findById(teacher.getId());
        if(testTeacher.isPresent()){
            return "Teacher Already Exists";
        } else{
            teacherRepository.save(new Teacher(teacher));
            return "Teacher Successfully Saved";
        }
    }

    @Override
    public String update(TeacherDTO teacher) {
        Optional<Teacher> targetTeacher = teacherRepository.findById(teacher.getId());
        if(targetTeacher.isPresent()){
            teacherRepository.save(new Teacher(teacher));
            return "Teacher was successfully Updated";
        } else{
            return "No Teacher was found";
        }
    }

    @Override
    public String delete(TeacherDTO teacher) {
        Optional<Teacher> targetTeacher = teacherRepository.findById(teacher.getId());
        if(targetTeacher.isPresent()){
            teacherRepository.deleteById(teacher.getId());
            return "Teacher was successfully Deleted";
        } else{
            return "No Teacher was found";
        }

    }

    @Override
    public List<TeacherDTO> getAll() {
        List<Teacher> teacherList = (List<Teacher>)teacherRepository.findAll();
        return teacherList
                .stream()
                .map(TeacherDTO::new)
                .collect(Collectors.toList());

    }
}
