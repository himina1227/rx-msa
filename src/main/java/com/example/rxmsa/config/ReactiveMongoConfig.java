package com.example.rxmsa.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * @author : nakgyeom
 * @date : 2022-11-04 오전 9:15
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.example.rxmsa.*")
public class ReactiveMongoConfig extends AbstractReactiveMongoConfiguration {

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://127.0.0.1:27017");
    }

    @Override
    protected String getDatabaseName() {
        return "rxmsa";
    }
}