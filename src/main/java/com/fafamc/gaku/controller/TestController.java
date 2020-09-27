package com.fafamc.gaku.controller;

import com.fafamc.gaku.domain.TTest;
import com.fafamc.gaku.mq.product.MqProduct;
import com.fafamc.gaku.redis.RedisUtil;
import com.fafamc.gaku.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author gaku9
 * @Create 2020/7/11
 **/
//@CrossOrigin   //跨域请求标签
@RequestMapping("/gaku")
@RestController
public class TestController {

    @Autowired
    private TestService service;
    @Autowired
    private MqProduct mqProduct;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public Object testController(HttpServletRequest request,HttpServletResponse response){
        Object o = service.testServiceMothed(1L);
//        redisUtil.set("forTest","1",60);
//        mqProduct.send();
        if(o != null){
            response.addCookie(new Cookie("token","lx_token"));
            return o;
        }
        return "NULL";
    }

    @RequestMapping("/test2")
    public Object testController2(HttpServletRequest request,HttpServletResponse response){
        Object o = service.testServiceMothed(2L);
//        mqProduct.send();
        if(o != null){
            return o;
        }
        return "NULL";
    }

    @RequestMapping("/test3")
    public Object testController3(@RequestBody TTest test){
        return test;
    }
}
