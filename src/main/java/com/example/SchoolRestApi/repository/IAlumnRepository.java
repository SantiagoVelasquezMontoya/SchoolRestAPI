package com.example.SchoolRestApi.repository;

import com.example.SchoolRestApi.repository.entity.Alumn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IAlumnRepository extends CrudRepository<Alumn, Integer> {

    List<Alumn>  findAlumnByAssignatureId(int id);
    Alumn findByAssignatureId(int id);

    @Query("select a from Alumn a where a.assignature.id = ?1")
    Optional<Alumn> findByAssignature_Id(Integer id);


}
