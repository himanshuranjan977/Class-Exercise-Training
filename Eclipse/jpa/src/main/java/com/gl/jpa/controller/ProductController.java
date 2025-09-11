package com.gl.jpa.controller;


import com.gl.jpa.model.Product;
import com.gl.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    // ➕ Add Product via params
    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestParam String name, @RequestParam double price) {
        Product saved = service.add(name, price);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // ✏️ Update Product via params
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam int id,
                                    @RequestParam String name,
                                    @RequestParam double price) {
        Product updated = service.update(id, name, price);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // 🔍 Get Product by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<Product> product = service.getById(id);
        return product.isPresent() ? ResponseEntity.ok(product.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }

    // ❌ Delete Product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}

