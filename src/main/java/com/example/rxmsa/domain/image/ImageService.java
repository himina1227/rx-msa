package com.example.rxmsa.domain.image;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : nakgyeom
 * @date : 2022-11-01 오전 11:13
 */
@RequiredArgsConstructor
@Service
public class ImageService {

    private final ResourceLoader resourceLoader;

    private static String UPLOAD_ROOT = "upload-dir";

    public Mono<Resource> findOne(String filename) {
        return Mono.fromSupplier(() ->
                resourceLoader.getResource(
                        "file:" + UPLOAD_ROOT + "/" + filename
                ));
    }

    public Mono<Void> create(Flux<FilePart> files) {
        return files
                .flatMap(file -> file.transferTo(
                        Paths.get(UPLOAD_ROOT, file.filename()).toFile()))
                .then();
    }

    public Mono<Void> delete(String filename) {
        return Mono.fromRunnable(() -> {
            try {
                Files.deleteIfExists(Paths.get(UPLOAD_ROOT, filename));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
