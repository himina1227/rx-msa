package com.example.rxmsa.domain.cart;

import com.example.rxmsa.domain.cart.item.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오전 9:43
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Cart {

    @Id
    private String id;

    private List<CartItem> cartItems;

    public Cart(String id) {
        this.id = id;
    }
}
