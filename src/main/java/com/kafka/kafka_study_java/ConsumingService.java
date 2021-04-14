package com.kafka.kafka_study_java;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.kafka.kafka_study_java.TopicConfig.TOPIC_TEST;

@Component
public class ConsumingService {

    @KafkaListener(containerFactory = "kafkaListenerFactory", topics = TOPIC_TEST)
    public void listenGroupFoo(String message){
        System.out.println("received message in group foo :" + message);
    }

}
