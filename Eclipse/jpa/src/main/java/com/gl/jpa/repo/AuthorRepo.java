package com.gl.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.jpa.model.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
}

