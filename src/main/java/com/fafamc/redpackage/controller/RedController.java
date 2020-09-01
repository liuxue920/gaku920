package com.fafamc.redpackage.controller;

import com.fafamc.redpackage.service.PackRedService;
import com.fafamc.redpackage.vo.ResponseResult;
import com.fafamc.redpackage.vo.SendVo;
import com.fafamc.weblog.config.WebLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/red")
public class RedController {

    @Autowired
    private PackRedService packRedService;

    @WebLog
    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public ResponseResult send(@RequestBody SendVo vo){
        ResponseResult result = new ResponseResult();
        result.setDate(packRedService.packRed(vo));
        return  result;
    }
}
