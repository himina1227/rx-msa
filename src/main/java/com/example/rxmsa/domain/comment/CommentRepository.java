package com.example.rxmsa.domain.comment;

import org.springframework.data.repository.Repository;
import reactor.core.publisher.Mono;

/**
 * @author : nakgyeom
 * @date : 2022-11-08 오후 1:12
 */
public interface CommentRepository extends Repository<Comment, String> {

    Mono<Comment>  save(Comment comment);

    Mono<Comment> findById(String id);
}
