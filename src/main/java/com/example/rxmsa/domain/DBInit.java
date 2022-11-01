package com.example.rxmsa.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : nakgyeom
 * @date : 2022-10-31 오후 1:49
 */
@Configuration
public class DBInit {

//    @Bean
//    CommandLineRunner init(ChapterRepository repository) {
//        return args -> {
//            Flux.just(
//                            new Chapter("Quick Start with Java"),
//                            new Chapter("Reactive Web with Spring Boot"),
//                            new Chapter("...and more!"))
//                    .flatMap(repository::save)
//                    .subscribe(System.out::println);
//        };
//    }
//    @Bean
//    CommandLineRunner init(MongoOperations operations) {
//        return args -> {
//            operations.dropCollection(Image.class);
//
//            operations.insert(new Image("1",
//                    "learning-spring-boot-cover.jpg"));
//            operations.insert(new Image("2",
//                    "learning-spring-boot-2nd-edition-cover.jpg"));
//            operations.insert(new Image("3",
//                    "bazinga.png"));
//
//            operations.findAll(Image.class).forEach(image -> {
//                System.out.println(image.toString());
//            });
//        };
//    }
}
