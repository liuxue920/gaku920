package com.fafamc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BizException  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public BizException(CommonEnum commonEnum){
        this.errorCode =  commonEnum.getResultCode();
        this.errorMsg = commonEnum.getResultMsg();
    }
}