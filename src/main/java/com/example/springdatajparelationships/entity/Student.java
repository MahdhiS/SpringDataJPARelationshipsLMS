package com.example.springdatajparelationships.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Student Entity - The "Many" side of One-to-Many relationship
 *
 * This entity represents a student in the database.
 * Each student belongs to ONE department (Many-to-One relationship)
 */
@Entity
@Table(name = "students")
public class Student {

    /**
     * Primary Key
     * @Id - Marks this field as the primary key
     * @GeneratedValue - Auto-generates the ID value
     * IDENTITY strategy uses database auto-increment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    /**
     * Student's last name
     */
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * 🔑 THE RELATIONSHIP - Many-to-One with Department
     *
     * @ManyToOne - Many students belong to One department
     * @JoinColumn - Specifies the foreign key column in students table
     * @JoinColumn(name = "department_id") - The column name in students table
     *
     * FetchType.LAZY - Don't load department data immediately
     * (Only load when we actually access student.getDepartment())
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = true)
    @JsonBackReference  // ADD THIS LINE
    private Department department;

    /**
     * Constructor with basic fields
     */
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Constructor with department
     */
    public Student(String firstName, String lastName, String email, Department department) {
        this(firstName, lastName, email);
        this.department = department;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}