package com.shop.supermarket.service;


import com.shop.supermarket.domain.Products;
import com.shop.supermarket.infrastructure.repository.ProductsRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository repository;

    public Flux<Products> getProducts(){
        return repository.findAll().log();

    }
}
