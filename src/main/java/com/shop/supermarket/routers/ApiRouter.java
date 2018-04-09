package com.shop.supermarket.routers;


import com.shop.supermarket.handlers.ErrorHandler;
import com.shop.supermarket.handlers.ProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
@RequiredArgsConstructor
public class ApiRouter {

    private static final String LOCATION_PATH = "/products";
    private static final String PRODUCTS_ARG = "/products/{type}";
    private static final String LOCATION_WITH_ADDRESS_PATH = LOCATION_PATH; //+ ADDRESS_ARG;

    private final ProductHandler productHandler;

    private final ErrorHandler errorHandler;

   @Bean
   RouterFunction<?> doRoute(final ProductHandler apiHandler, final ErrorHandler errorHandler) {
        return
                route(GET(LOCATION_WITH_ADDRESS_PATH), productHandler::getProducts)
                        .andRoute(GET(PRODUCTS_ARG), productHandler::getProductsByType)
                       .andOther(route(RequestPredicates.all(), errorHandler::notFound));

    }

}
