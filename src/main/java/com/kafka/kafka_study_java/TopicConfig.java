package com.kafka.kafka_study_java;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
    public static String TOPIC_AUTO_CREATE = "auto-create";
    public static final String TOPIC_TEST = "test";

    public NewTopic topicTest(){
        return new NewTopic(TOPIC_AUTO_CREATE, 1, (short)1);
    }


}
