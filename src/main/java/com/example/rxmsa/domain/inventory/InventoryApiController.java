package com.example.rxmsa.domain.inventory;

import com.example.rxmsa.domain.cart.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

/**
 * @author : nakgyeom
 * @date : 2022-11-14 오후 3:54
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/api/inventories")
public class InventoryApiController {

    private final InventoryService inventoryService;

    @GetMapping
    Mono<Rendering> home() { // <1>
        return Mono.just(Rendering.view("home.html") // <2>
                .modelAttribute("items", this.inventoryService.getInventory()) // <3>
                .modelAttribute("cart", this.inventoryService.getCart("My Cart") // <4>
                        .defaultIfEmpty(new Cart("My Cart")))
                .build());
    }
}
