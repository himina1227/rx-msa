package com.example.rxmsa.domain.cart;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오전 10:07
 */
public interface CartRepository extends ReactiveCrudRepository<Cart, String> {

    Mono<Cart> findById(String id);
}
