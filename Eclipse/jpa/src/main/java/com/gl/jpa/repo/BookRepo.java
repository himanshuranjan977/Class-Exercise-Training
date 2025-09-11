package com.gl.jpa.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.jpa.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
}

