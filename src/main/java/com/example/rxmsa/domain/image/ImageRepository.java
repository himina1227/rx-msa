package com.example.rxmsa.domain.image;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author : nakgyeom
 * @date : 2022-11-04 오전 8:34
 */
public interface ImageRepository extends ReactiveCrudRepository<Image, String> {

    Flux<Image> findByName(String name);
}
