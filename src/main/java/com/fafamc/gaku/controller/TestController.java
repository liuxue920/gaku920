package com.fafamc.gaku.controller;

import com.fafamc.gaku.mq.product.MqProduct;
import com.fafamc.gaku.redis.RedisUtil;
import com.fafamc.gaku.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Object testController(){
        Object o = service.testServiceMothed();
        redisUtil.set("forTest","1",60);
//        mqProduct.send();
        if(o != null){
            return o;
        }
        return "NULL";
    }
}
