package com.fafamc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author gaku9
 * @Create 2020/7/11
 **/
@MapperScan(basePackages ={"com.fafamc.gaku.dao,com.fafamc.redpackage.dao"})
//https://www.cnblogs.com/wangshichang/p/11418818.html 这个DataSourceAutoConfiguration exclude的原因是这个
// SecurityAutoConfiguration exclude的原因是由于springboot 2.0和activiti 6.0不匹配
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Starter {
    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(Starter.class);
        sa.addListeners(new MainBusiListeners());
        sa.run(args);
    }

}
