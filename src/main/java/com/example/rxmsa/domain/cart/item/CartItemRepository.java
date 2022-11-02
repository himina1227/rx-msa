package com.example.rxmsa.domain.cart.item;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오전 10:26
 */
public interface CartItemRepository extends ReactiveCrudRepository<CartItem, String> {
}
