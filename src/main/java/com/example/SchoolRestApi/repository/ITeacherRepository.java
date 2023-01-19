package com.example.SchoolRestApi.repository;

import com.example.SchoolRestApi.repository.entity.Teacher;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface ITeacherRepository extends CrudRepository<Teacher , Integer> {
}
