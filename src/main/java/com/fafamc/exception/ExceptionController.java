package com.fafamc.exception;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author gaku9
 * @Create 2020/7/11
 **/
@RequestMapping("/exception")
@RestController
public class ExceptionController {

    @RequestMapping("/test")
    public Object testController(){
        throw new BizException(CommonEnum.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping("/test2")
    public Object testController(@RequestBody TestRequestBody testRequestBody){
        return testRequestBody;
    }
}
