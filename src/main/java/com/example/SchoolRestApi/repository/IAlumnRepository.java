package com.example.SchoolRestApi.repository;

import com.example.SchoolRestApi.repository.entity.Alumn;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnRepository extends CrudRepository<Alumn, Integer> {
}
