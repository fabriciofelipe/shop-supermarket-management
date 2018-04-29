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
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductsService productsService;

    private final ErrorHandler errorHandler;


   public Mono<ServerResponse> getProducts(ServerRequest request) {
        Flux<Products> products  = productsService.getProducts();
       return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products, Products.class);

    }

    public Mono<ServerResponse> getProductsByType(ServerRequest request) {
        String type = request.pathVariable("type");
        Flux<Products> products  = productsService.getProductsByType(type);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products, Products.class);

    }

    public Mono<ServerResponse> addProducts(ServerRequest request){
           Mono<Products> product = request.bodyToMono(Products.class);
           return ServerResponse.ok().build(productsService.add(product).then());
    }

    public Mono<ServerResponse> updateProducts(ServerRequest request){
        Mono<Products> product = request.bodyToMono(Products.class);
        return ServerResponse.ok().build(productsService.update(product).then());
    }


}
