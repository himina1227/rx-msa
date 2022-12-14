package com.example.rxmsa.domain.inventory;

import com.example.rxmsa.domain.cart.Cart;
import com.example.rxmsa.domain.cart.CartRepository;
import com.example.rxmsa.domain.cart.item.CartItem;
import com.example.rxmsa.domain.item.Item;
import com.example.rxmsa.domain.item.ItemRepository;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * spring boot reactive
 * @author : nakgyeom
 * @date : 2022-11-14 오후 4:16
 */
@ExtendWith(SpringExtension.class)
class InventoryServiceTest {

    InventoryService inventoryService;

    @MockBean
    private ItemRepository itemRepository; // <2>

    @MockBean
    private CartRepository cartRepository; // <2>

    @BeforeEach
    void setUp() {
        Item sampleItem = new Item("item1", "TV tray", "Alf TV tray", BigDecimal.TEN);
        CartItem sampleCartItem = new CartItem(sampleItem);
        Cart sampleCart = Cart.builder().id("My cart").cartItems(Arrays.asList(sampleCartItem)).build();
//                new Cart("My Cart", Arrays.asList(sampleCartItem));

        when(cartRepository.findById(anyString())).thenReturn(Mono.empty());
        when(itemRepository.findById(anyString())).thenReturn(Mono.just(sampleItem));
        when(cartRepository.save(any())).thenReturn(Mono.just(sampleCart));

        inventoryService = new InventoryService(cartRepository, itemRepository); // <4>
    }

    @Test
    void cartFindById() {
        Cart sampleCart = new Cart("My Cart123123");
        Mono<Cart> cart = cartRepository.save(sampleCart);
        cartRepository.save(sampleCart).subscribe(result -> Assertions.assertEquals("My cart", result.getId()));
        itemRepository.findById("aa").subscribe(
                result -> assertEquals("item1", result.getId())
        );
    }

    @Test
    void addItemToEmptyCartShouldProduceOneCartItem() { // <1>
        Mono<Cart> monoCart =  inventoryService.addItemToCart("My Cart", "item1");
        System.out.println(monoCart);
        inventoryService.addItemToCart("My Cart", "item1") // <2>
                .as(StepVerifier::create) // <3>
                .expectNextMatches(cart -> { // <4>
                    assertThat(cart.getCartItems()).extracting(CartItem::getQuantity) //
                            .containsExactlyInAnyOrder(1); // <5>

                    assertThat(cart.getCartItems()).extracting(CartItem::getItem) //
                            .containsExactly(new Item("item1", "TV tray", "Alf TV tray", BigDecimal.valueOf(10))); // <6>

                    return true; // <7>
                }) //
                .verifyComplete(); // <8>
    }

//    @Test
//    void alternativeWayToTest() { // <1>
//        StepVerifier.create( //
//                        inventoryService.addItemToCart("My Cart", "item1")) //
//                .expectNextMatches(cart -> { // <4>
//                    assertThat(cart.getCartItems()).extracting(CartItem::getQuantity) //
//                            .containsExactlyInAnyOrder(1); // <5>
//
//                    assertThat(cart.getCartItems()).extracting(CartItem::getItem) //
//                            .containsExactly(new Item("item1", "TV tray", "Alf TV tray", BigDecimal.valueOf(19))); // <6>
//
//                    return true; // <7>
//                }) //
//                .verifyComplete(); // <8>
//    }
}