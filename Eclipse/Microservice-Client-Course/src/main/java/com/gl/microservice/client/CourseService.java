package com.gl.microservice.client;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    // old method kept for flexibility
    public void add(Course course) {
        courseRepo.save(course);
    }

    // new method for controller
    public void addCourse(String name, double fees, int categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Course course = new Course(name, fees, category);
        courseRepo.save(course);
    }

    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    public Course getById(int id) {
        return courseRepo.findById(id).orElse(null);
    }

    // old method kept
    public void update(Course course) {
        courseRepo.save(course);
    }

    // new method for controller
    public void updateCourse(int id, String name, double fees, int categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setName(name);
        course.setFees(fees);
        course.setCategory(category);

        courseRepo.save(course);
    }

    public void delete(int id) {
        courseRepo.deleteById(id);
    }
}
