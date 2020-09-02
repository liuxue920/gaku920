package com.fafamc.redpackage.controller;

import com.fafamc.exception.ResultBody;
import com.fafamc.redpackage.service.PackRedService;
import com.fafamc.redpackage.service.ScrambleRedService;
import com.fafamc.redpackage.vo.GetVo;
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
    @Autowired
    private ScrambleRedService scrambleRed;

    @WebLog
    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public ResultBody send(@RequestBody SendVo vo){
        return ResultBody.success(packRedService.packRed(vo));
    }

    @WebLog
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public ResultBody get(@RequestBody GetVo vo){
        return ResultBody.success(scrambleRed.getRed(vo));
    }


    @WebLog
    @RequestMapping(value = "/open",method = RequestMethod.POST)
    public ResultBody openRed(@RequestBody GetVo vo){
        return ResultBody.success(scrambleRed.openRed(vo));
    }
}
