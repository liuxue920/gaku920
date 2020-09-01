package com.fafamc.redpackage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author gaku9
 * @Create 2020/7/29
 **/
@Data
public class SendVo {
    // 由于为止的驼峰命名的问题，这个属性传递异常，加上这个注解之后解决
    @JsonProperty(value = "pNum")
    private Integer pNum;//多少个红包
    private Integer eachMoney;//每个多少钱
    private String message;

    private int model;//什么模式 0平均  1抢红包
    private Integer totalMoney;//一共多少钱

}
