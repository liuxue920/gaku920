package com.fafamc.gaku.controller;

import com.fafamc.gaku.mq.product.MqProduct;
import com.fafamc.gaku.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author gaku9
 * @Create 2020/7/11
 **/
@RequestMapping("/")
@RestController
public class TestController {

    @Autowired
    private TestService service;
    @Autowired
    private MqProduct mqProduct;

    @RequestMapping("/test")
    public Object testController(){
        Object o = service.testServiceMothed();
        mqProduct.send();
        if(o != null){
            return o;
        }
        return "NULL";
    }
}
