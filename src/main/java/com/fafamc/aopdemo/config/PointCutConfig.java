package com.fafamc.aopdemo.config;

import com.fafamc.aopdemo.dto.EmailSendDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author gaku9
 * @Create 2020/7/17
 **/
@Slf4j
@Aspect
@Component
public class PointCutConfig {

    @Pointcut("execution( * com.fafamc.aopdemo.service.SendMessage.sendEmail(..)) && args(emailSendDto)")
    public void lx(EmailSendDto emailSendDto){
        System.out.println(123);
    }

    /**
     * @description  在连接点执行之前执行的通知
     */
    @Around("lx(emailSendDto)")
    public void around(ProceedingJoinPoint pjp,EmailSendDto emailSendDto) throws Throwable {
        System.out.println("##########################");
        System.out.println("传递进来的对象");
        System.out.println(emailSendDto.toString());
        pjp.proceed();
        Object[] object = pjp.getArgs();
        EmailSendDto dto = (EmailSendDto) object[0];
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("获取的对象");
        System.out.println(dto.toString());

        System.out.println("5555555555555555");
    }


}
