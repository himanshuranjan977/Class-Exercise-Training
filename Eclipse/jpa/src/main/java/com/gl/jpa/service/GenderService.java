package com.gl.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Gender;
import com.gl.jpa.repo.GenderRepo;

@Service
public class GenderService {

    @Autowired
    GenderRepo repo;

    // Add new Gender
    public void add(Gender gender) {
        repo.save(gender);
    }

    // Get all Genders
    public List<Gender> getAll() {
        return repo.findAll();
    }

    // Get by ID
    public Gender getById(int id) {
        Optional<Gender> genderOpt = repo.findById(id);
        // ✅ Correct null check
        return genderOpt.orElse(null);
    }

    // Update Gender
    public void update(Gender gender) {
        repo.save(gender);
    }

    public void delete(int id) {
        Gender gender = new Gender();
        gender.setId(id);
        repo.delete(gender);
    }
}
