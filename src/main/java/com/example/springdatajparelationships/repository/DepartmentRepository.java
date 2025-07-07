package com.example.springdatajparelationships.repository;

import com.example.springdatajparelationships.entity.Department;
import com.example.springdatajparelationships.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
