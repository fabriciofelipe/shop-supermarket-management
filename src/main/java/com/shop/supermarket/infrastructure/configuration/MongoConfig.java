package com.shop.supermarket.infrastructure.configuration;


import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.shop.supermarket.infrastructure.repository.ProductsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = ProductsRepository.class)
public class MongoConfig extends AbstractReactiveMongoConfiguration {


    @Override
    protected String getDatabaseName() {
        return "shop-supermarket";
    }

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    //@Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }
}
