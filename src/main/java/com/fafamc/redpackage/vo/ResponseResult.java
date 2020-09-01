package com.fafamc.redpackage.vo;

import lombok.Data;

@Data
public class ResponseResult<T> {
    private String code;
    private T date;
    private String message;
}
