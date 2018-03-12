package com.shop.supermarket.handlers;

import com.shop.supermarket.domain.Products;
import com.shop.supermarket.service.ProductsService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductHandler {

    @Autowired
    private ProductsService productsService;
    private ErrorHandler errorHandler;


   public Mono<ServerResponse> getProducts(ServerRequest request) {
        Flux<Products> products  = productsService.getProducts();
       return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products, Products.class);

    }



}
