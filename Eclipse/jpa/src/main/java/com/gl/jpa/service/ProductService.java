package com.gl.jpa.service;

import com.gl.jpa.model.Product;
import com.gl.jpa.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    // ➕ Add Product using params
    public Product add(String name, double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return repo.save(product);
    }

    // ✏️ Update Product using params
    public Product update(int id, String name, double price) {
        Optional<Product> productOpt = repo.findById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setName(name);
            product.setPrice(price);
            return repo.save(product);
        }
        return null; // not found
    }

 // 🔍 Get all products
    public List<Product> getAll() {
        return repo.findAll();
    }
    
    

    // 🔍 Get Product by ID
    public Optional<Product> getById(int id) {
        return repo.findById(id);
    }

    // ❌ Delete Product
    public void delete(int id) {
        repo.deleteById(id);
    }
}

