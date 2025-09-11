package com.gl.hiber;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "courses")   // reverse mapping
    private List<Student> students;

    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    // getters and setters
}
