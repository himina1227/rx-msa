package com.example.rxmsa.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author : nakgyeom
 * @date : 2022-11-08 오후 1:24
 */
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository repository;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "learning-spring-boot"),
            key = "comments.new"
    ))
    public void save(Comment newComment) {
        repository.save(newComment)
                .log("commentService-save")
                .subscribe();
    }
}
