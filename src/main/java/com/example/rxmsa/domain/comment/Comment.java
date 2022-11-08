package com.example.rxmsa.domain.comment;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : nakgyeom
 * @date : 2022-11-08 오전 10:54
 */
@Data
@Document
public class Comment {

    @Id
    private String id;

    private String imageId;

    private String comment;
}
