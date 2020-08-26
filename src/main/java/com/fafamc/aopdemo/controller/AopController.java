package com.fafamc.aopdemo.controller;

import com.fafamc.aopdemo.dto.EmailSendDto;
import com.fafamc.aopdemo.serviceimpl.SupplierSendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author gaku9
 * @Create 2020/7/29
 **/
@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    private SupplierSendEmail sendMessage;

    @RequestMapping("/method")
    public void aopTest(){
        EmailSendDto email = new EmailSendDto();
        email.setUserName("lx");
        email.setModel("supplier");
        sendMessage.sendEmail(email);
    }
}
