package com.gl.hiber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Vehicle() {}
    public Vehicle(String name, Student student) {
        this.name = name;
        this.student = student;
    }

    // Getters & Setters
}

