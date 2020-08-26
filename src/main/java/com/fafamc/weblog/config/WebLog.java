package com.fafamc.weblog.config;

import java.lang.annotation.*;

/**
 * @Author gaku9
 * @Create 2020/7/29
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    String description() default "";
}
