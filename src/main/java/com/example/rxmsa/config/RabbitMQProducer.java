//package com.example.rxmsa.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Required;
//import org.springframework.cloud.stream.function.StreamBridge;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//
//import java.util.UUID;
//
///**
// * @author : nakgyeom
// * @date : 2022-11-09 오후 4:05
// */
//@RequiredArgsConstructor
//@Component
//public class RabbitMQProducer {
//
//    private final StreamBridge streamBridge; // StreamBridge를 주입해주자.
//
//    @Async
//    public void send(SpringbootKRPayload payload) {
//        streamBridge.send("outputSample-out-0", MessageBuilder
//                //  ↑ application.yml의 (1)과 같아야합니다.
//                // send의 첫번째 String parameter 이름은 String bindingName 입니다.
//                .withPayload(payload)
//                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
//                .build());
//    }
//}
