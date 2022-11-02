package com.example.rxmsa.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.FluentMongoOperations;
import org.springframework.data.mongodb.core.ReactiveFluentMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoOperationsExtensionsKt;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오전 11:10
 */
@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository repository;

    private final ItemByExampleRepository itemByExampleRepository;

    private final ReactiveFluentMongoOperations mongoOperations;

    public Flux<Item> searchByExample(String name, String description, boolean useAnd) {
        Item item = new Item(name, description, BigDecimal.ZERO);

        ExampleMatcher matcher = (useAnd ? ExampleMatcher.matchingAll() : ExampleMatcher.matchingAny()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING))
                .withIgnoreCase()
                .withIgnorePaths("price");

        Example<Item> probe = Example.of(item, matcher);
        return itemByExampleRepository.findAll(probe);
    }

//    public Flux<Item> searchByFluentExample(String name, String description, boolean useAnd) {
//        return mongoOperations.query(Item.class)
//                .matching(query(where("TV tray").is(name).and("smurf").is(description)))
//                .all();
//    }
}
