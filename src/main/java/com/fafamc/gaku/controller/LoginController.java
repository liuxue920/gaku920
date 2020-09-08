package com.fafamc.gaku.controller;

import com.fafamc.exception.ResultBody;
import com.fafamc.gaku.domain.LocalUser;
import com.fafamc.gaku.domain.Role;
import com.fafamc.gaku.redis.RedisUtil;
import com.fafamc.gaku.util.LocalInfo;
import com.fafamc.gaku.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public ResultBody testController(@RequestParam("name")String name, @RequestParam("password")String password){

        //TODO  db
        if("zhangsan".equals(name) && "123".equals(password)){

            Role r = new Role();
            r.setCode("admin");
            List roleList = new ArrayList();
            roleList.add(r);

            LocalUser user = new LocalUser();
            user.setId("12");
            user.setName("zhangsan");
            user.setRoleList(roleList);

            String token = UUIDUtil.getUUID();
            redisUtil.set("user_"+token,user,60*10);
            LocalInfo.set(user);

            return ResultBody.success();
        }
        return ResultBody.error("login failed");
    }
}
