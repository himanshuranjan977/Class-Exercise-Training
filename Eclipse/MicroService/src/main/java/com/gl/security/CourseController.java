package com.gl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Create course using params
    @PostMapping("/add")
    public Course addCourse(@RequestParam String name, @RequestParam Double fees) {
        Course course = new Course(name, fees);
        return courseService.saveCourse(course);
    }

    // Update course using params
    @PutMapping("/update")
    public Course updateCourse(@RequestParam Long id, @RequestParam String name, @RequestParam Double fees) {
        Optional<Course> existing = courseService.getCourseById(id);
        if (existing.isPresent()) {
            Course course = existing.get();
            course.setName(name);
            course.setFees(fees);
            return courseService.saveCourse(course);
        } else {
            throw new RuntimeException("Course not found with ID " + id);
        }
    }

    // Get all courses
    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Get course by ID
    @GetMapping("/get")
    public Optional<Course> getCourse(@RequestParam Long id) {
        return courseService.getCourseById(id);
    }

    // Delete course
    @DeleteMapping("/delete")
    public String deleteCourse(@RequestParam Long id) {
        courseService.deleteCourse(id);
        return "Course with ID " + id + " deleted successfully!";
    }
}

