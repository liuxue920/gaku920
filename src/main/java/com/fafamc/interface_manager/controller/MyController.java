package com.fafamc.interface_manager.controller;

import com.fafamc.interface_manager.config.GakuMethodMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@GakuMethodMapping("interface_manager")
public class MyController {

    @GakuMethodMapping("/test1")
    public String test1(){
        return "123";
    }
}
