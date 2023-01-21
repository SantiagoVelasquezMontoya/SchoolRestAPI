package com.example.SchoolRestApi.repository;

import com.example.SchoolRestApi.repository.entity.Teacher;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITeacherRepository extends CrudRepository<Teacher , Integer> {
}
