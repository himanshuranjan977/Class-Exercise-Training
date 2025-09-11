package com.gl.jpa.controller;

import com.gl.jpa.model.Book;
import com.gl.jpa.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    // ➕ Add a new book (via request param)
    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestParam String name) {
        Book book = bookService.add(name);   // directly pass param
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    // 🔍 Get all books
    @GetMapping("/all")
    public ResponseEntity<Iterable<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    // 🔍 Get book by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<Book> book = bookService.getById(id);
        return book.isPresent() ? ResponseEntity.ok(book.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
    }

    // ❌ Delete book by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        bookService.delete(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

    // 📌 Map author to book
    @PostMapping("/mapauthor")
    public ResponseEntity<?> mapAuthor(@RequestParam int bookId, @RequestParam int authorId) {
        Book book = bookService.assignAuthor(bookId, authorId);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error mapping author to book");
        }

        return ResponseEntity.ok(book);
    }
}



