package com.example.rxmsa.domain.item;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오전 9:03
 */
public interface ItemRepository extends ReactiveCrudRepository<Item, String>, ReactiveQueryByExampleExecutor<Item> {

    Mono<Item> findByName(String name);
}
