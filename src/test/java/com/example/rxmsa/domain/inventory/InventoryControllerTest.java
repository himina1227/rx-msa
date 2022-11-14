package com.example.rxmsa.domain.inventory;

import com.example.rxmsa.domain.cart.Cart;
import com.example.rxmsa.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author : nakgyeom
 * @date : 2022-11-14 오후 3:15
 */
@WebFluxTest(InventoryController.class)
class InventoryControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    InventoryService inventoryService;

    @Test
    void home() {
        when(inventoryService.getInventory()).thenReturn(Flux.just( //
                new Item("id1", "name1", "desc1", BigDecimal.TEN), //
                new Item("id2", "name2", "desc2", BigDecimal.ONE) //
        ));
        when(inventoryService.getCart("My Cart")) //
                .thenReturn(Mono.just(new Cart("My Cart")));

        client.get().uri("/inventories/").exchange() //
                .expectStatus().isOk() //
                .expectBody(String.class) //
                .consumeWith(exchangeResult -> {
                    assertThat( //
                            exchangeResult.getResponseBody()).contains("action=\"/add/id1\"");
                    assertThat( //
                            exchangeResult.getResponseBody()).contains("action=\"/add/id2\"");
                });

    }
}