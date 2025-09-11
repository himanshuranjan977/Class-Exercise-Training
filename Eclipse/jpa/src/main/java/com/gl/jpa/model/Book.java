package com.gl.jpa.model;

import jakarta.persistence.*;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "book_author", // join table name
        joinColumns = @JoinColumn(name = "book_id"), // FK to Book
        inverseJoinColumns = @JoinColumn(name = "author_id") // FK to Author
    )
    @JsonManagedReference
    private Set<Author> authors;

    public Book() {}

    public Book(String name) {
        this.name = name;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Author> getAuthors() { return authors; }
    public void setAuthors(Set<Author> authors) { this.authors = authors; }
}

