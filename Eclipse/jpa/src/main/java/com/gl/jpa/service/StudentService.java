package com.gl.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Course;
import com.gl.jpa.model.Student;
import com.gl.jpa.repo.CourseRepo;
import com.gl.jpa.repo.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    // Create new student
    public Student add(String name, int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return studentRepo.save(student);
    }

    // Updating the course for a student
    public Student assignCourse(int studentId, int courseId) {
        // Fetch the student
        Optional<Student> studentOpt = studentRepo.findById(studentId);
        if (studentOpt.isEmpty()) {
            System.err.println("No student found with id " + studentId);
            return null;
        }

        // Fetch the course
        Optional<Course> courseOpt = courseRepo.findById(courseId);
        if (courseOpt.isEmpty()) {
            System.err.println("No course found with id " + courseId);
            return null;
        }

        // Actual mapping work
        Student student = studentOpt.get();
        student.getCourses().add(courseOpt.get());

        // Save the student (updates mapping table automatically)
        return studentRepo.save(student);
    }
}

