package com.example.rxmsa.common;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : nakgyeom
 * @date : 2022-11-01 오후 1:24
 */
public class CommonTest {

    @Test
    public void createFlux_just() {
        Flux.just("alpha", "bravo", "charlie");
    }

    @Test
    public void createFlux_fromArray() {
        String[] items = new String[]{"alpha", "bravo", "charlie"};
        Flux.fromArray(items);
    }

    @Test
    public void createFlux_fromIterable() {
        List<String> items = Arrays.asList("alpha", "bravo", "charlie");
        Flux.fromIterable(items);
    }

    @Test
    public void createFlux_fromStream() {
        Stream<String> items = Arrays.asList("alpha", "bravo", "charlie").stream();
        Flux.fromStream(items);
    }

    @Test
    public void createFlux_just_subscribe() {
        Flux.just("alpha", "bravo", "charlie")
                .subscribe(System.out::println);
    }

    @Test
    public void createFlux_interval() {
        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(1))
                .take(3);

        StepVerifier.create(intervalFlux)
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .verifyComplete();
    }

    @Test
    public void distinct() {
        Flux<String> animalFlux = Flux.just("dog", "cat", "bird", "dog", "bird")
                .distinct();

        StepVerifier.create(animalFlux)
                .expectNext("dog", "cat", "bird")
                .verifyComplete();
    }

    @Test
    public void data6() {
        Flux.just("alpha", "bravo", "charlie")
                .map(String::toUpperCase)
                .flatMap(s -> Flux.fromArray(s.split("")))
                .groupBy(String::toString)
                .sort((o1, o2) -> o1.key().compareTo(o2.key()))
                .flatMap(group -> Mono.just(group.key()).zipWith(group.count()))
                .map(keyAndCount -> keyAndCount.getT1() + " => " + keyAndCount.getT2())
                .subscribe(System.out::println);
    }
}

