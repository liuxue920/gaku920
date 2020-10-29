package com.fafamc.gaku.service;

import com.fafamc.gaku.dao.TestDao;
import com.fafamc.gaku.domain.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    private TestDao testDao;

    public TTest testServiceMothed(Long id){
        TTest domain =  testDao.selectByPrimaryKey(id);
        if("zhangsan".equals(domain.getName())){
            System.out.println("123");
        }else{
            System.out.println("45");
        }
        return domain;
    }

    private void testPrivate(){
        System.out.println("234");
    }

    public static String testStatic(){
        return "123";
    }
}
