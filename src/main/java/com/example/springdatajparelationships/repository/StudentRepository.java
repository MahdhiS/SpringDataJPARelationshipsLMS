package com.example.springdatajparelationships.repository;

import com.example.springdatajparelationships.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByDepartmentId(Long departmentId);
}
