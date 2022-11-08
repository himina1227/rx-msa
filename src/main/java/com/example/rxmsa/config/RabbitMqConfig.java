package com.example.rxmsa.config;

import com.example.rxmsa.support.RabbitMqExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : nakgyeom
 * @date : 2022-11-08 오후 4:09
 */
@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {

    private final int MAX_TRY_COUNT = 3;
    private final int INITIAL_INTERVAL = 3000;
    private final int MULTIPLIER = 3;
    private final int MAX_INTERVAL = 10000;

    private final ConnectionFactory connectionFactory;

    @Bean
    public RabbitTemplate amqpTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setChannelTransacted(true);
        rabbitTemplate.setReplyTimeout(60000);
        rabbitTemplate.setMessageConverter(queueMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setDefaultRequeueRejected(false);
        factory.setMessageConverter(queueMessageConverter());
        factory.setChannelTransacted(true);
        factory.setAdviceChain(RetryInterceptorBuilder
                .stateless()
                .maxAttempts(MAX_TRY_COUNT)
                .recoverer(new RabbitMqExceptionHandler())
                .backOffOptions(INITIAL_INTERVAL, MULTIPLIER, MAX_INTERVAL)
                .build());
        return factory;
    }

    private Jackson2JsonMessageConverter queueMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
