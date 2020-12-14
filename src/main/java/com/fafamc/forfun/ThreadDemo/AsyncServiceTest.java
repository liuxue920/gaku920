package com.fafamc.forfun.ThreadDemo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceTest {

    @Async("myAsync")
    public void sendMail(String username) {
        System.out.println("Send Mail initialization...");
        System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
            System.out.println("异步发送邮件 " + username);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Send Mail Async done!!!");
    }

}
