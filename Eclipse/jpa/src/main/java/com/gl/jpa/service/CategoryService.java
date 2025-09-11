package com.gl.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Category;
import com.gl.jpa.repo.CategoryRepo;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    //  Find category by id
    public Category findById(int id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    //  Add new category
    public Category add(String name) {
        return categoryRepo.save(new Category(name));
    }

    //  Get all categories
    public Iterable<Category> getAll() {
        return categoryRepo.findAll();
    }

    //  Delete category
    public void delete(int id) {
        categoryRepo.deleteById(id);
    }
}

