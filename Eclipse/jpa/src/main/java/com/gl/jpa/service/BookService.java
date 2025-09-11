package com.gl.jpa.service;

import com.gl.jpa.model.Book;
import com.gl.jpa.model.Author;
import com.gl.jpa.repo.BookRepo;
import com.gl.jpa.repo.AuthorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    // ➕ Add new Book (with name only)
    public Book add(String name) {
        Book book = new Book();
        book.setName(name);
        return bookRepo.save(book);
    }

    // 🔍 Get all Books
    public Iterable<Book> getAll() {
        return bookRepo.findAll();
    }

    // 🔍 Get Book by id
    public Optional<Book> getById(int id) {
        return bookRepo.findById(id);
    }

    // ❌ Delete Book by id
    public void delete(int id) {
        bookRepo.deleteById(id);
    }

    // 📌 Assign author to book
    public Book assignAuthor(int bookId, int authorId) {
        Optional<Book> bookOpt = bookRepo.findById(bookId);
        Optional<Author> authorOpt = authorRepo.findById(authorId);

        if (bookOpt.isPresent() && authorOpt.isPresent()) {
            Book book = bookOpt.get();
            Author author = authorOpt.get();

            Set<Author> authors = book.getAuthors();
            if (authors == null) {
                authors = new HashSet<>();
            }
            authors.add(author);
            book.setAuthors(authors);

            return bookRepo.save(book);
        }
        return null;
    }
}



