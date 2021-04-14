package com.kafka.kafka_study_java;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static com.kafka.kafka_study_java.TopicConfig.TOPIC_TEST;

@Component
public class PublishingService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate ;

    public void sendToTest(String msg){
        kafkaTemplate.send(TOPIC_TEST, msg);
    }

    public void sendToTestWithLog(String msg){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC_TEST, msg);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
               @Override
               public void onFailure(Throwable ex) {
                   System.out.printf("Unable to send message = %s due to : $s", msg, ex.getLocalizedMessage());
               }

               @Override
               public void onSuccess(SendResult<String, String> result) {
                   System.out.printf("sent message = $s with offset = $d", msg, result.getRecordMetadata().offset());
               }
           }

        );


    }
}
