package com.example.SchoolRestApi.repository;

import com.example.SchoolRestApi.repository.entity.Alumn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IAlumnRepository extends CrudRepository<Alumn, Integer> {

    List<Alumn>  findAlumnByAssignatureId(int id);

}
