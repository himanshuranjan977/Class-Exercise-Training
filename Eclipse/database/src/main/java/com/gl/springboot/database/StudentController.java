package com.gl.springboot.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

    @Autowired
    StudentService studentService;

    // ✅ Add Student
    @PostMapping("/student/add")
    public ResponseEntity addStudent(Student student) {
        studentService.insertStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("Student inserted");
    }

    // ✅ List All Students
    @GetMapping("/student/list")
    public ResponseEntity listStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
}
