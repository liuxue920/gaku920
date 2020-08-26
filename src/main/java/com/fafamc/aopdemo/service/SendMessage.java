package com.fafamc.aopdemo.service;

import com.fafamc.aopdemo.dto.EmailSendDto;

/**
 * @Author gaku9
 * @Create 2020/7/17
 **/
public interface SendMessage {

    public void sendEmail(EmailSendDto emailSendDto);

    public void sendMessage();
}
