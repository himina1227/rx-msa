package com.example.rxmsa.domain.cart.item;

import com.example.rxmsa.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오전 9:44
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class CartItem {

    private Item item;

    private int quantity;

    public CartItem(Item item) {
        this.item = item;
        this.quantity = 1;
    }
    public void increment() {
        this.quantity++;
    }

    public void decrement() {
        this.quantity--;
    }
}
