package com.fafamc.forfun.ThreadDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
    /** Set the ThreadPoolExecutor's core pool size. */
//    @Value("${core.pool.size}")
    private Integer corePoolSize=5;

    /** Set the ThreadPoolExecutor's maximum pool size. */
//    @Value("${max.pool.size}")
    private Integer maxPoolSize=20;

    /** Set the capacity for the ThreadPoolExecutor's BlockingQueue. */
//    @Value("${queue.capacity}")
    private Integer queueCapacity=30;

//    @Value("${thread.name.prefix}")
//    private String ThreadNamePrefix;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("myAsync")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
//        executor.setThreadNamePrefix(ThreadNamePrefix);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;
    }

}
