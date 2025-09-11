package com.gl.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gl.jpa.model.Student;
import com.gl.jpa.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    // Add a new student
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam String name, @RequestParam int age) {
        Student student = studentService.add(name, age);

        if (student != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in creating student");
    }

    // Assign a course to a student
    @PostMapping("/{studentId}/assignCourse/{courseId}")
    public ResponseEntity<?> assignCourse(
            @PathVariable int studentId,
            @PathVariable int courseId) {

        Student student = studentService.assignCourse(studentId, courseId);

        if (student != null) {
            return ResponseEntity.ok(student);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error assigning course to student");
    }

    // Alternative mapping (with params)
    @PostMapping("/mapcourse")
    public ResponseEntity<?> mapCourse(@RequestParam int studentId, @RequestParam int courseId) {
        Student student = studentService.assignCourse(studentId, courseId);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in mapping the course");
        }

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
}
