package com.example.rxmsa.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author : nakgyeom
 * @date : 2022-11-09 오후 5:02
 */
@Component
public class SinkConfig {

    private final Log logger = LogFactory.getLog(getClass());

    private final EmitterProcessor<Message<?>> processor = EmitterProcessor.create();

    @Bean
    public Supplier<Flux<Message<?>>> supplier() {
        return () -> processor;
    }

    @Bean
    public Consumer<String> receive1() {
        return data -> logger.info("Data received from customer-1..." + data);
    }

    @Bean
    public Consumer<String> receive2() {
        return data -> logger.info("Data received from customer-2..." + data);
    }
}
