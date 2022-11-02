package com.example.rxmsa.domain.cart;

import com.example.rxmsa.domain.cart.item.CartItem;
import com.example.rxmsa.domain.cart.item.CartItemRepository;
import com.example.rxmsa.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오전 10:08
 */
@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository repository;

    private final ItemRepository itemRepository;

    private final CartItemRepository cartItemRepository;

    Mono<Cart> addToCart(String cartId, String id) {
        return this.repository.findById(cartId)
                .defaultIfEmpty(new Cart(cartId))
                .flatMap(cart -> cart.getCartItems()
                        .stream()
                        .filter(cartItem -> cartItem.getItem().getId().equals(id))
                        .findAny()
                        .map(cartItem -> {
                            cartItem.increment();
                            return Mono.just(cart);
                        })
                        .orElseGet(() ->
                                this.itemRepository.findById(id)
                                        .map(CartItem::new)
                                        .doOnNext(cartItem ->
                                                cart.getCartItems().add(cartItem))
                                        .map(cartItem -> cart)))
                .flatMap(this.repository::save);
    }
}
