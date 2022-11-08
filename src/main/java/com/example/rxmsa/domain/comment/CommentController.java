package com.example.rxmsa.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author : nakgyeom
 * @date : 2022-11-08 오후 4:23
 */
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/comments")
    public Mono<String> addComment(Mono<Comment> newComment) {
        return newComment.flatMap(comment ->
                        Mono.fromRunnable(() ->
                                        rabbitTemplate
                                                .convertAndSend(
                                                        "learning-spring-boot",
                                                        "comments.new",
                                                        comment))
                                .then(Mono.just(comment)))
                                .log("commentService-publish")
                                .flatMap(comment -> Mono.just("sample"));
    }
}
