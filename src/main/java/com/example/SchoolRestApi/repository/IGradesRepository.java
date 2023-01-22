package com.example.SchoolRestApi.repository;

import com.example.SchoolRestApi.repository.entity.Grades;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradesRepository extends CrudRepository<Grades, Integer> {
}
