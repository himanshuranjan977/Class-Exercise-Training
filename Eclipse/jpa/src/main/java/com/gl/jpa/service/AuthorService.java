package com.gl.jpa.service;

import com.gl.jpa.model.Author;
import com.gl.jpa.model.Book;
import com.gl.jpa.repo.AuthorRepo;
import com.gl.jpa.repo.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private BookRepo bookRepo;

    // ➕ Add new Author using params
    public Author add(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepo.save(author);
    }

    // 🔍 Get all Authors
    public Iterable<Author> getAll() {
        return authorRepo.findAll();
    }

    // 🔍 Get author by id
    public Optional<Author> getById(int id) {
        return authorRepo.findById(id);
    }

    // ❌ Delete author by id
    public void delete(int id) {
        authorRepo.deleteById(id);
    }

    // 📌 Assign book to author (reverse mapping)
    public Author assignBook(int authorId, int bookId) {
        Optional<Author> authorOpt = authorRepo.findById(authorId);
        Optional<Book> bookOpt = bookRepo.findById(bookId);

        if (authorOpt.isPresent() && bookOpt.isPresent()) {
            Author author = authorOpt.get();
            Book book = bookOpt.get();

            Set<Book> books = author.getBooks();
            if (books == null) {
                books = new HashSet<>();
            }
            books.add(book);
            author.setBooks(books);

            return authorRepo.save(author);
        }
        return null;
    }
}


