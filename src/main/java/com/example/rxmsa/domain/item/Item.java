package com.example.rxmsa.domain.item;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오전 9:00
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Item {

    @Id
    private String id;

    private String name;

    private String description;

    private BigDecimal price;

    public Item(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
