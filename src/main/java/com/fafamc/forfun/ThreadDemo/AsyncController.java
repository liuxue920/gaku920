package com.fafamc.forfun.ThreadDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;

@RestController
public class AsyncController {
    @Autowired
    private AsyncServiceTest service;

    @RequestMapping("async")
    public String test(){

        CountDownLatch latch = new CountDownLatch(5);
        for(int i = 0; i< 5;i++){
            service.sendMail("lx"+i);
            Field[] fields = service.getClass().getFields();
            System.out.println();
            latch.countDown();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "1234";
    }
}
