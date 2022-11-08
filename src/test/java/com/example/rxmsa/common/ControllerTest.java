package com.example.rxmsa.common;

import com.example.rxmsa.domain.cart.Cart;
import com.example.rxmsa.domain.chapter.ChapterApiController;
import com.example.rxmsa.domain.inventory.InventoryService;
import com.example.rxmsa.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오후 3:52
 */
@WebFluxTest(ChapterApiController.class) // <1>
public class ControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    InventoryService inventoryService;

//    @Test
//    void homePage() {
//        when(inventoryService.getInventory()).thenReturn(Flux.just( //
//                new Item("id1", "name1", "desc1", BigDecimal.ONE),
//                new Item("id2", "name2", "desc2", BigDecimal.TEN)
//        ));
//        when(inventoryService.getCart("My Cart")) //
//                .thenReturn(Mono.just(new Cart("My Cart")));
//
//        client.get().uri("/").exchange()
//                .expectStatus().isOk()
//                .expectBody(String.class)
//                .consumeWith(exchangeResult -> {
//                    assertThat(
//                            exchangeResult.getResponseBody()).contains("action=\"/add/id1\"");
//                    assertThat(
//                            exchangeResult.getResponseBody()).contains("action=\"/add/id2\"");
//                });
//    }
}