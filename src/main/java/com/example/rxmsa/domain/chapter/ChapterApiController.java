package com.example.rxmsa.domain.chapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chapters")
public class ChapterApiController {

    private final ChapterService service;

    @GetMapping("/getAll")
    public Flux<Chapter> listing() {
        return service.findAll();
    }
}
