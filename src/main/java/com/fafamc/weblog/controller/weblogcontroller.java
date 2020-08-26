package com.fafamc.weblog.controller;

import com.fafamc.weblog.config.WebLog;
import com.fafamc.weblog.vo.QueryVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author gaku9
 * @Create 2020/7/29
 **/
@RequestMapping("/weblog")
@RestController
public class weblogcontroller {

    @Value("${config.param.cup}")
    private String cupName;

    @WebLog
    @RequestMapping(value = "/method",method = RequestMethod.POST)
    public void testWebLog(@RequestBody QueryVo vo){
        System.out.println("do some things"+cupName);
    }

    @WebLog
    @RequestMapping(value = "/method2",method = RequestMethod.GET)
    public void testWebLog(@RequestParam("name")String name,@RequestParam("code")String code){
        System.out.println("do some things"+cupName);
    }
}
