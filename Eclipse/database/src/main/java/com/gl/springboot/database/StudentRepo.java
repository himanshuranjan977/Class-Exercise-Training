package com.gl.springboot.database;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	// If name is unique (only one student per name)
    Student findByName(String name);

    // If multiple students can have the same name
    List<Student> findAllByName(String name);
    
    List<Student> findByAgeGreaterThan(int age);


}
