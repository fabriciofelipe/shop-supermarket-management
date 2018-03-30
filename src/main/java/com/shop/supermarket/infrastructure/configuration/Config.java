package com.shop.supermarket.infrastructure.configuration;

import com.shop.supermarket.handlers.ErrorHandler;
import com.shop.supermarket.handlers.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ProductHandler productHandler(){
        return new ProductHandler();
    }

    @Bean
    ErrorHandler errorHandler(){
        return new ErrorHandler();
    }
}
