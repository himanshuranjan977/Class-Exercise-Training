package com.gl.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.gl.jpa.model.Animal;
import com.gl.jpa.service.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService service;

    // Add new animal
    @PostMapping("/add")
    public ResponseEntity<Animal> add(@RequestParam String name, @RequestParam int age) {
        Animal animal = new Animal(name, age);
        Animal saved = service.add(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get all animals
    @GetMapping("/all")
    public ResponseEntity<List<Animal>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Get by ID
   /* @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Animal> animal = service.getById(id);
        return animal.isPresent() ? ResponseEntity.ok(animal.get())
                                  : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal not found");
    }
    */
    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam Long id) {
        try {
            Optional<Animal> animalOpt = service.getById(id);

            if (animalOpt.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(animalOpt.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal not found");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Animal not found: " + ex.getMessage());
        }
    }

    
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam Long id, 
                                    @RequestParam String name, 
                                    @RequestParam int age) {
        Animal animal = new Animal(name, age);
        animal.setId(id);   // set the id for updating
        service.add(animal);  // save() works as both insert & update in JPA
        return ResponseEntity.status(HttpStatus.OK)
                             .body("Animal updated successfully");
    }


    /*// Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Animal deleted successfully");
    }
    */
    
    /*@DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Animal deleted successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Animal not found: " + ex.getMessage());
        }
    }
    */
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Animal deleted successfully");
    }


}

