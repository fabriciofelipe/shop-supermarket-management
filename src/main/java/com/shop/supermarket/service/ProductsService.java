package com.shop.supermarket.service;


import com.shop.supermarket.domain.Products;
import com.shop.supermarket.infrastructure.repository.ProductsRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductsService {


    @Autowired
    private ProductsRepository repository;


    public Flux<Products> getProducts(){
        return repository.findAll().log();

    }
}
