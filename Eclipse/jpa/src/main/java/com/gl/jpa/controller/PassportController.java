package com.gl.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.jpa.model.Passport;
import com.gl.jpa.service.PassportService;

@RestController
public class PassportController {

    @Autowired
    private PassportService passportService;

    @PostMapping("/passport/add")
    public ResponseEntity<String> add(@RequestParam String passportNumber,
                                      @RequestParam int personId) {
        passportService.add(passportNumber, personId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Passport added successfully");
    }

    @GetMapping("/passport/getall")
    public ResponseEntity<List<Passport>> getAll() {
        List<Passport> passports = passportService.getAll();
        System.out.println("passports " + passports.size());
        return ResponseEntity.status(HttpStatus.OK).body(passports);
    }

    @GetMapping("/passport/getbyid")
    public ResponseEntity<?> getById(@RequestParam int id) {
        Passport passport = passportService.getById(id);

        if (passport == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Invalid passport id");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(passport);
    }
    
    @PutMapping("/passport/update")
    public ResponseEntity<String> update(@RequestParam int passportId,
                                         @RequestParam String passportNumber,
                                         @RequestParam int personId) {
        Passport passport = passportService.update(passportId, passportNumber, personId);

        if (passport == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Invalid passport or person id");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Passport updated successfully");
    }
    
 // PassportController.java
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id) {
        boolean deleted = passportService.delete(id);

        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Invalid passport id");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Passport deleted successfully");
    }

}

