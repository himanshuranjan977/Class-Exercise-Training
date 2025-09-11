package com.gl.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.gl.jpa.model.Course;
import com.gl.jpa.repo.CourseRepo;

@Service
public class CourseService {

    @Autowired
    private CourseRepo repo;

    // Add new course
    public Course add(Course course) {
        return repo.save(course);
    }

    // Get all courses
    public List<Course> getAll() {
        return repo.findAll();
    }

    // Get course by id
    public Optional<Course> getById(Integer id) {
        return repo.findById(id);
    }

    // Delete course
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
