package com.example.rxmsa.domain.chapter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

/**
 * @author : nakgyeom
 * @date : 2022-10-31 오후 1:49
 */
@Configuration
public class DBInit {

    @Bean
    CommandLineRunner init(ChapterRepository repository) {
        return args -> {
            Flux.just(
                            new Chapter("Quick Start with Java"),
                            new Chapter("Reactive Web with Spring Boot"),
                            new Chapter("...and more!"))
                    .flatMap(repository::save)
                    .subscribe(System.out::println);
        };
    }

}
