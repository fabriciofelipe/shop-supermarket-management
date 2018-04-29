package com.shop.supermarket.infrastructure.repository;

import com.shop.supermarket.domain.Products;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductsRepository extends ReactiveMongoRepository<Products, String> {

    Flux<Products> findByType(String type);

}



