package com.shop.supermarket.infrastructure.repository;

import com.shop.supermarket.domain.Products;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductsRepository extends ReactiveMongoRepository<Products, String> {


}


