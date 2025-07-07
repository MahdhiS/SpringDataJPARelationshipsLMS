package com.example.springdatajparelationships.service;

import com.example.springdatajparelationships.entity.Department;
import com.example.springdatajparelationships.entity.Student;
import com.example.springdatajparelationships.repository.DepartmentRepository;
import com.example.springdatajparelationships.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Department saveDetails(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    //one to many
    public List<Student> getDepartmentStudents(long id) {
        Department department = getDepartmentById(id);
        if (department != null) {
            return department.getStudents();
        }
        return null;
    }

    public boolean deleteDepartment(long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Department updateDepartment(long id, Department departmentDetails) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            department.setName(departmentDetails.getName());
            department.setDescription(departmentDetails.getDescription());
            return departmentRepository.save(department);
        }
        return null;
    }


}
