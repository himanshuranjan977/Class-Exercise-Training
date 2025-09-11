package com.gl.hiber;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gender {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name; // Male, Female, etc.

    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
    private List<Student> students;

    public Gender() {}
    public Gender(String name) {
        this.name = name;
    }

    // Getters & Setters
}
