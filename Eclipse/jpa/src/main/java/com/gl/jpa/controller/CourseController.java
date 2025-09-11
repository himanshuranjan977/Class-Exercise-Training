package com.gl.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.gl.jpa.model.Course;
import com.gl.jpa.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    // Add new course
    @PostMapping("/add")
    public ResponseEntity<Course> add(@RequestParam String name,
                                      @RequestParam double fee,
                                      @RequestParam int duration) {
        Course course = new Course(name, fee, duration);
        Course saved = service.add(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get all courses
    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Get course by ID
    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam Integer id) {
        Optional<Course> courseOpt = service.getById(id);
        if (courseOpt.isPresent()) {
            return ResponseEntity.ok(courseOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
    }

    // Update course
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam Integer id,
                                    @RequestParam String name,
                                    @RequestParam double fee,
                                    @RequestParam int duration) {
        Course course = new Course(name, fee, duration);
        course.setId(id); // Set the ID to update
        service.add(course); // save() works as insert/update
        return ResponseEntity.ok("Course updated successfully");
    }

    // Delete course
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Course deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found: " + e.getMessage());
        }
    }
}


