package com.fafamc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author gaku9
 * @Create 2020/7/11
 **/
@MapperScan(basePackages ="com.fafamc.gaku.dao")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //https://www.cnblogs.com/wangshichang/p/11418818.html 这个exclude的原因是这个
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
