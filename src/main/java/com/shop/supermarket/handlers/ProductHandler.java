package com.shop.supermarket.handlers;

import com.shop.supermarket.domain.Products;
import com.shop.supermarket.service.ProductsService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class ProductHandler {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ErrorHandler errorHandler;


   public Mono<ServerResponse> getProducts(ServerRequest request) {
        Flux<Products> products  = productsService.getProducts();
       return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products, Products.class);

    }

    public Mono<ServerResponse> getProductsByType(ServerRequest request) {
        String type = request.pathVariable("type");
        Flux<Products> products  = productsService.getProductsByType(type);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products, Products.class);

    }



}
