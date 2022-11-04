package com.example.rxmsa.domain.image;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : nakgyeom
 * @date : 2022-11-04 오전 8:06
 */
@SpringBootTest
class ImageServiceTest {

    @Autowired
    ImageRepository repository;

    @Autowired
    ImageService service;

    @Autowired
    ReactiveMongoTemplate operations;

    @BeforeEach
    public void setUp() {
        operations.dropCollection(Image.class);

        operations.insert(new Image("1", "learning-spring-boot-cover.jpg"));
        operations.insert(new Image("2", "learning-spring-boot-2nd-edition-cover.jpg"));
        operations.insert(new Image("3", "bazinga.png"));
    }

    @Test
    public void findOneImage() {
        service.findOne("learning-spring-boot.png").block(Duration.ofSeconds(30));
    }

    @Test
    public void deleteImage() {
        service.delete("learning-spring-boot.png").block(Duration.ofSeconds(30));
    }

}