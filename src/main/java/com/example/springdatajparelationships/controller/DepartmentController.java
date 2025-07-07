package com.example.springdatajparelationships.controller;


import com.example.springdatajparelationships.entity.Department;
import com.example.springdatajparelationships.entity.Student;
import com.example.springdatajparelationships.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //create
    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.saveDetails(department);
    }

    //read

    @GetMapping("/getalldepartments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/getdepartment/{id}")
    public Department getDepartmentById(@PathVariable long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/getdepartmentstudents/{id}/students")
    public List<Student> getDepartmentStudents(@PathVariable long id) {
        return departmentService.getDepartmentStudents(id);
    }

    //update
    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    //del
    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable long id) {
        boolean deleted = departmentService.deleteDepartment(id);
        if (deleted) {
            return "Department deleted successfully!";
        }
        return "Department not found!";
    }





}
