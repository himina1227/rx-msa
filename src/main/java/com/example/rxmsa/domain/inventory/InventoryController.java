package com.example.rxmsa.domain.inventory;

import com.example.rxmsa.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author : nakgyeom
 * @date : 2022-11-14 오후 2:50
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/inventories")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/add/{id}")
    Mono<String> addToCart(@PathVariable String id) {
        return this.inventoryService.addItemToCart("My Cart", id)
                .thenReturn("redirect:/");
    }

    @DeleteMapping("/remove/{id}")
    Mono<String> removeFromCart(@PathVariable String id) {
        return this.inventoryService.removeOneFromCart("My Cart", id)
                .thenReturn("redirect:/");
    }

    @PostMapping
    Mono<String> createItem(@ModelAttribute Item newItem) {
        return this.inventoryService.saveItem(newItem) //
                .thenReturn("redirect:/");
    }

    @DeleteMapping("/delete/{id}")
    Mono<String> deleteItem(@PathVariable String id) {
        return this.inventoryService.deleteItem(id) //
                .thenReturn("redirect:/");
    }
}
