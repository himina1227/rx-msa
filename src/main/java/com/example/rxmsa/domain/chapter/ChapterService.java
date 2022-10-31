package com.example.rxmsa.domain.chapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class ChapterService {
    private final ChapterRepository repository;

    public Flux<Chapter> findAll() {
        return repository.findAll();
    }
}
