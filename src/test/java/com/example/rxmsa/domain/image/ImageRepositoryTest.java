package com.example.rxmsa.domain.image;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : nakgyeom
 * @date : 2022-11-04 오후 1:36
 */
@ActiveProfiles("local")
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class ImageRepositoryTest {

    @Autowired
    ImageRepository repository;

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
        repository.findByName("learning-spring-boot-2nd-edition-cover.jpg")
                .as(StepVerifier::create)
                .expectNextMatches(image -> {
                    assertThat(image.getId()).isEqualTo(2);

                    return true;
                });
    }
}