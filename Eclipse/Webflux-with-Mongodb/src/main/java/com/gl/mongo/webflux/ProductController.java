package com.gl.mongo.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    // Add product
    @PostMapping("/add")
    public Mono<Product> addProduct(@RequestParam String name, @RequestParam double price) {
        Product p = new Product(name, price);
        return productRepo.save(p);
    }

    //  Get all products
    @GetMapping("/all")
    public Flux<Product> getAllProducts() {
        return productRepo.findAll();
    }

  
}


