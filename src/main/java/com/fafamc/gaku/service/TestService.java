package com.fafamc.gaku.service;

import com.fafamc.gaku.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author gaku9
 * @Create 2020/7/11
 **/
@Service
public class TestService {
    @Autowired
    private TestDao testDao;

    public Object testServiceMothed(){
        return testDao.selectByPrimaryKey(1L);
    }
}
