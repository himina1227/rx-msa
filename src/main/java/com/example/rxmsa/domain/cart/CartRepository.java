package com.example.rxmsa.domain.cart;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오전 10:07
 */
public interface CartRepository extends ReactiveCrudRepository<Cart, String> {
}
