package com.example.rxmsa.domain.comment;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author : nakgyeom
 * @date : 2022-11-09 오후 3:10
 */
public interface CustomProcessor {

    String INPUT = "input";
    String OUTPUT = "emptyOutput";

    SubscribableChannel inputSample();

    MessageChannel outputSample();
}
