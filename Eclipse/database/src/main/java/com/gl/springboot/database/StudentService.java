package com.gl.springboot.database;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    // Insert a single student
    
    public void insertStudent(Student student) {
        if (student.getAge() < 5) {
            System.err.println(" Student age cannot be less than 5");
        } else {
            repo.save(student);
            System.out.println(" Student inserted");
        }
    }


    // Insert multiple students
    public void insertManyStudents(List<Student> students) {
        repo.saveAll(students);
    }
    
    //get the data from the database
    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll(); // fetch all rows from the table
        return students;
    }
    
    public Student getStudentById(int id) {
        Optional<Student> student = repo.findById(id);

        // Case 1: student found
        if (student.get()==null) {
        	System.err.println("No student found with id " + id);
            return null;
        }
        // Case 2: student not found
        else {
            
            return student.get();
        }
    }
    
    public List<Student> getAllStudentsOrderByName() {
        //return repo.findAll(Sort.by("name"));
    	
    	// 2. Sort by name DESC
        // return repo.findAll(Sort.by("name").descending());

        // 3. Sort by age DESC
        // return repo.findAll(Sort.by("age").descending());

        // 4. Sort by age ASC, then by name ASC
        // return repo.findAll(Sort.by("age").ascending().and(Sort.by("name").ascending()));

        
        return repo.findAll(
                Sort.by("age").descending()
                    .and(Sort.by("name").ascending()));
    }
    
    
    public boolean searchByName(String name) {
        // Creating a sample object with only the name field set
        Student studentSample = new Student();
        studentSample.setName(name);

        // Create where clause (ExampleMatcher)
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains()) // contains => LIKE '%name%'
                .withIgnorePaths("id", "age"); // ignore fields we don’t want in the match

        // Merge the sample object with the matcher
        Example<Student> example = Example.of(studentSample, exampleMatcher);

        // Check if a record exists that matches the condition
        return repo.exists(example);
    }
    
    public List<Student> getAllStudentsByName(String name) {
        return repo.findAllByName(name);
    }
    
    public List<Student> getByAboveAge(int age) {
        return repo.findByAgeGreaterThan(age);
    }
    
    
    
}

