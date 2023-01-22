package com.example.SchoolRestApi.repository;

import com.example.SchoolRestApi.repository.entity.Grades;
import org.springframework.data.repository.CrudRepository;

public interface IGradesRepository extends CrudRepository<Grades, Integer> {
}
