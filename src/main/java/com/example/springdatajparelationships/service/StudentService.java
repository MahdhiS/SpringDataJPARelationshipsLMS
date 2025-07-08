package com.example.springdatajparelationships.service;

import com.example.springdatajparelationships.entity.Department;
import com.example.springdatajparelationships.entity.Student;
import com.example.springdatajparelationships.repository.DepartmentRepository;
import com.example.springdatajparelationships.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    DepartmentRepository departmentRepository;



    public Student saveDetails(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveAllDetails(List<Student> student) {
        return studentRepository.saveAll(student);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getStudentsByDepartmentId(Long departmentId){
        return studentRepository.findByDepartmentId(departmentId);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateDetails(int id, Student updatedStudent) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            return studentRepository.save(student);
        }
        return null;
    }

    public Student assignStudentToDepartment(int studentId, Long departmentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            Department department = departmentRepository.findById(departmentId).orElse(null);
            student.setDepartment(department);
            return studentRepository.save(student);
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
