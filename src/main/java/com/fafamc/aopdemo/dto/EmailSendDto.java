package com.fafamc.aopdemo.dto;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @Author gaku9
 * @Create 2020/7/17
 **/
@Data
public class EmailSendDto implements Serializable {

    private String id;
    private String model;
    private String userName;

    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
