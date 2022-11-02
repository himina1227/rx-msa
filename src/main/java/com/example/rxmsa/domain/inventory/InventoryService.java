package com.example.rxmsa.domain.inventory;

import com.example.rxmsa.domain.cart.Cart;
import com.example.rxmsa.domain.cart.CartRepository;
import com.example.rxmsa.domain.cart.item.CartItem;
import com.example.rxmsa.domain.item.ItemRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오후 3:55
 */
@RequiredArgsConstructor
@Service
public class InventoryService {

    private final CartRepository cartRepository;

    private final ItemRepository itemRepository;

    public Mono<Cart> addItemToCart(String cartId, String itemId) {
        return this.cartRepository.findById(cartId)
                .defaultIfEmpty(new Cart(cartId)).flatMap(cart -> cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getItem().getId().equals(itemId))
                .findAny()
                .map(cartItem -> {
                    cartItem.increment();
                    return Mono.just(cart);
                })
                .orElseGet(() -> this.itemRepository.findById(itemId)
                        .map(item -> new CartItem(item))
                        .map(cartItem -> {
                            cart.getCartItems().add(cartItem);
                            return cart;
                        }))
                .flatMap(this.cartRepository::save));
    }
}
