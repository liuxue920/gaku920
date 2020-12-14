package com.fafamc.gaku.kafka;

import org.springframework.stereotype.Component;

@Component
public class CustomerKafkaListener {
//    @KafkaListener(topics="testTopic_lx")
    public void onMessage(String message){
        System.out.println(message);
    }
}
