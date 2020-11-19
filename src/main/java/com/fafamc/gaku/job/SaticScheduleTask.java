package com.fafamc.gaku.job;

import com.fafamc.gaku.dao.TestDao;
import com.fafamc.gaku.domain.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    private TestDao testDao;

    //3.添加定时任务
    //@Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    public void configureTasks() {
        TTest t =  testDao.selectByPrimaryKey(1L);
        System.out.println(t.getName());
        System.out.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}