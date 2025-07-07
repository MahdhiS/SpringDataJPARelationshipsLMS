package com.example.springdatajparelationships.controller;

import com.example.springdatajparelationships.entity.Student;
import com.example.springdatajparelationships.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //create
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveDetails(student);
    }

    @PostMapping("/addstudentlist")
    public List<Student> addStudentLists(@RequestBody List<Student> students) {
        return studentService.saveAllDetails(students);
    }


    // read
    @GetMapping("/getallstudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getstudent/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Student> getStudentsByDepartment(@PathVariable Long departmentId) {
        return studentService.getStudentsByDepartmentId(departmentId);
    }

    //update
    @PutMapping("/updatestudent/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateDetails(id, student);
    }

    @PutMapping("/assign/{studentId}/department/{departmentId}")
    public Student assignStudentToDepartment(
            @PathVariable int studentId,
            @PathVariable Long departmentId) {
        return studentService.assignStudentToDepartment(studentId, departmentId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return "Student deleted successfully!";
        }
        return "Student not found!";
    }




}
