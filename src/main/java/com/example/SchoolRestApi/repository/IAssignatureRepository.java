package com.example.SchoolRestApi.repository;

import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.repository.entity.Alumn;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.repository.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAssignatureRepository extends CrudRepository<Assignature, Integer> {
    @Query("select a from Assignature a where a.teacher = ?1")
    Optional<Assignature> findByTeacher(Teacher teacher);


}
