package com.example.rxmsa.domain.employee;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : nakgyeom
 * @date : 2022-11-01 오후 1:48
 */
@Data
@Document
public class Employee {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String role;
}
