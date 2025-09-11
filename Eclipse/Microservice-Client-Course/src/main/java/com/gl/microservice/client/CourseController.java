package com.gl.microservice.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course/add")
    public ResponseEntity add(@RequestBody Course course) {
        
            courseService.add(course);
            return ResponseEntity.status(HttpStatus.OK).body(course);
        
    }

    @GetMapping("/course/getall")
    public ResponseEntity<List<Course>> getAll() {
        List<Course> courses = courseService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @GetMapping("/course/getbyid")
    public ResponseEntity<?> getById(@RequestParam int id) {
        Course course = courseService.getById(id);
        if (course != null) {
            return ResponseEntity.status(HttpStatus.OK).body(course);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
    }

    @PutMapping("/course/update")
    public ResponseEntity<String> update(@RequestParam int id,
                                         @RequestParam String name,
                                         @RequestParam double fees,
                                         @RequestParam int categoryId) {
        try {
            courseService.updateCourse(id, name, fees, categoryId);
            return ResponseEntity.status(HttpStatus.OK).body("Course updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating course");
        }
    }

    @DeleteMapping("/course/delete")
    public ResponseEntity<String> delete(@RequestParam int id) {
        try {
            courseService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Course deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
    }
}



