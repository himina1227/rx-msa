package com.example.rxmsa.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;

import java.nio.charset.StandardCharsets;

/**
 * @author : nakgyeom
 * @date : 2022-11-08 오후 4:13
 */
@Slf4j
public class RabbitMqExceptionHandler extends RejectAndDontRequeueRecoverer {

    @Override
    public void recover(Message message, Throwable cause) {

        final byte[] body = message.getBody();
        final String msg = new String(body, StandardCharsets.UTF_8);
        log.error("===================");
        log.debug(msg);
        log.warn("Retries exhausted for message " + message, cause);
        log.error("===================");
    }

}
