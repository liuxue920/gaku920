package com.fafamc.gaku.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author gaku9
 * @Create 2020/7/14
 **/
@Component
@RabbitListener(queues = "helloQueue")
public class MqConsumer {


    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}