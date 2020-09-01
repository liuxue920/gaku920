package com.fafamc.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;

//@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value =BizException.class)
    public ResultBody exceptionHandler(BizException e){
        System.out.println("未知异常！原因是:"+e);
        return ResultBody.error(e.getErrorCode(),e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value =Exception.class)
    public ResultBody exceptionHandler(Exception e){
        System.out.println("未知异常！原因是:"+e);
        return ResultBody.error(e.getMessage());
    }

    @InitBinder//("testRequestBody")
    public void initBinder(WebDataBinder binder) throws IllegalAccessException {
        System.out.println(ToStringBuilder.reflectionToString(binder));
        Object obj = binder.getTarget();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field f : fields){
            f.setAccessible(true);
            Class t = f.getType();
            if(t == String.class){
//                String abc = (String)f.get(obj);SSS
//                f.set(obj,abc+"_dev");
            }
        }
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }
}
