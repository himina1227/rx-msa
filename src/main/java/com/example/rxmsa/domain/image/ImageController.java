package com.example.rxmsa.domain.image;

import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author : nakgyeom
 * @date : 2022-11-01 오전 11:33
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    public Mono<String> createFile(@RequestPart(name = "file" )Flux<FilePart> files) {
        return imageService.create(files)
                .then(Mono.just("redirect:/"));
    }

    @DeleteMapping("/{filename}")
    public Mono<String> deleteFile(@PathVariable String filename) {
        return imageService.delete(filename)
                .then(Mono.just("redirect:/"));
    }

}
