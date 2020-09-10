package com.fafamc.gaku.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 配置出现问题，解决方式
 * https://blog.csdn.net/weixin_42362496/article/details/103805993
 * yml文件配置list
 */
@Data
@EnableConfigurationProperties
@Configuration
@ConfigurationProperties(prefix = "path")
public class PathPatterns {

    private List<String> patterns;

//    private Map<String,String> maps;

}
