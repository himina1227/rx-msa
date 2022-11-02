package com.example.rxmsa.domain.image;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : nakgyeom
 * @date : 2022-11-01 오전 11:05
 */
@Data
@NoArgsConstructor
public class Image {

    private String id;
    private String name;

    public Image(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
