package com.gl.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    // Add or Update course
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    // Get course by ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepo.findById(id);
    }

    // Delete course
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}

