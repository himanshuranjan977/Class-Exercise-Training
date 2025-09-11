package com.gl.jpa.controller;

import com.gl.jpa.model.Author;
import com.gl.jpa.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // ➕ Add a new author using params
    @PostMapping("/add")
    public ResponseEntity<Author> add(@RequestParam String name) {
        Author savedAuthor = authorService.add(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthor);
    }

    // 🔍 Get all authors
    @GetMapping("/all")
    public ResponseEntity<Iterable<Author>> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    // 🔍 Get author by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<Author> author = authorService.getById(id);
        return author.isPresent() ? ResponseEntity.ok(author.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
    }

    // ❌ Delete author by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        authorService.delete(id);
        return ResponseEntity.ok("Author deleted successfully");
    }

    // 📌 Map book to author
    @PostMapping("/mapbook")
    public ResponseEntity<?> mapBook(@RequestParam int authorId, @RequestParam int bookId) {
        Author author = authorService.assignBook(authorId, bookId);

        if (author == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error mapping book to author");
        }

        return ResponseEntity.ok(author);
    }
}



