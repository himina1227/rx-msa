package com.example.rxmsa.domain.item;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

/**
 * @author : nakgyeom
 * @date : 2022-11-02 오전 10:58
 */
public interface ItemByExampleRepository extends ReactiveQueryByExampleExecutor<Item> {
}
