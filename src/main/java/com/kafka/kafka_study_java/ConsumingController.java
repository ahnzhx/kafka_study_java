package com.kafka.kafka_study_java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class ConsumingController {

    @Autowired
    private ConsumingService consumingService;

    @GetMapping("/")
    public void  aa(){

    }
}
