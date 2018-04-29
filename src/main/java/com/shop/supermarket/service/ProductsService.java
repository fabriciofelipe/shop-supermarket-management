package com.shop.supermarket.service;


import com.shop.supermarket.domain.Products;
import com.shop.supermarket.infrastructure.repository.ProductsRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository repository;

    public Flux<Products> getProducts() {
        return repository.findAll();

    }

    public Flux<Products> getProductsByType(String type) {
        return repository.findByType(type);

    }

    public Mono<Products> add(Mono<Products> product) {
       return product.flatMap(this::applyAdd);
    }

    private Mono<Products> applyAdd(Products products){
        products.setCreated(DateTime.now());
        return repository.save(products);
    }

    public Mono<Products> update(Mono<Products> product) {
        return product.flatMap(this::applyUpdate);
    }

    private Mono<Products> applyUpdate(Products products){
        products.setLastModified(DateTime.now());
        return repository.save(products);
    }
}