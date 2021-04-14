package com.kafka.kafka_study_java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class PublishingController {
    @Autowired
    private PublishingService publishingService;

    @GetMapping
    public String send (@RequestParam String msg){
        publishingService.sendToTest(msg);
        return msg;
    }
}
