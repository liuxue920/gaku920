package com.fafamc.interface_manager.config;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;

public class GakuMethodMappingHandler extends AbstractHandlerMethodMapping<RequestMappingInfo> {

    @Override
    protected boolean isHandler(Class beanType) {
        return beanType.getDeclaredAnnotation(RestController.class) != null || beanType.getDeclaredAnnotation(Controller.class) != null;//判断一个Handler是不是controller
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo info = createRequestMappingInfo(method);// 方法上的注解
        if (info != null) {
            RequestMappingInfo typeInfo = createRequestMappingInfo(handlerType);//类上的注解
            if (typeInfo != null) {
                info = typeInfo.combine(info);//组合
            }
        }
        return info;
    }

    @Override
    protected Set<String> getMappingPathPatterns(RequestMappingInfo mapping) {
        return mapping.getPatternsCondition().getPatterns();
    }

    @Override
    protected RequestMappingInfo getMatchingMapping(RequestMappingInfo mapping, HttpServletRequest request) {
        Set<String> patterns = mapping.getPatternsCondition().getPatterns();
        for (String pattern : patterns) {
            if (pattern.equals(request.getServletPath())) {
                return mapping;
            }
        }
        return null;
    }

    @Override
    protected Comparator<RequestMappingInfo> getMappingComparator(HttpServletRequest request) {
        return (info1, info2) -> info1.compareTo(info2, request);
    }

    private RequestMappingInfo createRequestMappingInfo(AnnotatedElement element) {
        GakuMethodMapping annotation = AnnotatedElementUtils.findMergedAnnotation(element, GakuMethodMapping.class);
        if (annotation == null) return null;

        RequestMappingInfo.Builder builder = RequestMappingInfo
                .paths(annotation.value());
        return builder.build();
    }

    @Override
    public void afterPropertiesSet() {
        super.setOrder(-1);//这里是为了优先级要超过RequestResponseBodyMethodProcessor
        super.afterPropertiesSet();
    }
}