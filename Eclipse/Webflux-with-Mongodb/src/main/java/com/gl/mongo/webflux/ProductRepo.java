package com.gl.mongo.webflux;



import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepo extends ReactiveMongoRepository<Product, String> {
}