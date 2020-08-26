package com.fafamc.aopdemo.serviceimpl;

import com.fafamc.aopdemo.dto.EmailSendDto;
import com.fafamc.aopdemo.service.SendMessage;
import org.springframework.stereotype.Service;

/**
 * @Author gaku9
 * @Create 2020/7/17
 **/
@Service
public class SupplierSendEmail implements SendMessage {
    @Override
    public void sendEmail(EmailSendDto emailSendDto) {
        System.out.println("do same send action");
    }

    @Override
    public void sendMessage() {

    }
}
