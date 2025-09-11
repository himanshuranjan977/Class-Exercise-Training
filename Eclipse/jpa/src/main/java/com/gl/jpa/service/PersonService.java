package com.gl.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Gender;
import com.gl.jpa.model.Person;
import com.gl.jpa.repo.PersonRepo;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    GenderService genderService; // we can get the gender by id

    public void add(String name, int genderId) {
        Gender gender = genderService.getById(genderId);

        if (gender == null) {
            System.err.println("Invalid gender id");
            
        }

        Person person = new Person(name, gender);
        personRepo.save(person);
    }
    public List<Person> getAll() {
        return personRepo.findAll();
    }
    
    public Person getById(int id) {
        try {
            Optional<Person> personOpt = personRepo.findById(id);
            return personOpt.orElse(null); // return the person if present, else null
        } catch (Exception ex) {
            
            return null;
        }
    }
}
