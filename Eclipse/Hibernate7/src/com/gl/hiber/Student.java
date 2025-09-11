package com.gl.hiber;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Many students → One gender
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    // One student ↔ One vehicle
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Vehicle vehicle;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_course", // join table
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
    public Student() {}
 // Constructor without vehicle
    public Student(String name, Gender gender, List<Course> courses) {
        this.name = name;
        this.gender = gender;
        this.courses = courses;
    }
    
 // Constructor with vehicle
    public Student(String name, Gender gender, Vehicle vehicle, List<Course> courses) {
        this.name = name;
        this.gender = gender;
        this.vehicle = vehicle;
        this.courses = courses;
    }
    
    
   
	

    // Getters & Setters
}

