package com.fafamc;

import com.fafamc.gaku.util.SpringApplicationContextUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 启动的监听，设置spring上线文
 * Starter中配置
 */
public class MainBusiListeners implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        SpringApplicationContextUtil.setApplicationContext(event.getApplicationContext());
    }
}