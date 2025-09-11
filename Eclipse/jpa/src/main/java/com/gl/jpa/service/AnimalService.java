package com.gl.jpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.gl.jpa.model.Animal;
import com.gl.jpa.repo.AnimalRepo;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepo repo;

    // Add new animal
    public Animal add(Animal animal) {
        return repo.save(animal);
    }

    // Get all animals
    public List<Animal> getAll() {
        return repo.findAll();
    }

    // Get animal by id
    public Optional<Animal> getById(Long id) {
        return repo.findById(id);
    }

    // Delete animal
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

