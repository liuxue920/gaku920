package com.fafamc.gaku.config;

import com.fafamc.gaku.redis.RedisUtil;
import com.fafamc.gaku.util.SpringApplicationContextUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
            //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
//            User user=(User)request.getSession().getAttribute("USER");
        RedisUtil redisUtil = SpringApplicationContextUtil.getBean(RedisUtil.class);

        Cookie[] cookies = request.getCookies();
        String value ="";
        if(cookies != null && cookies.length != 0){
            for(Cookie c : cookies){
                if("token".equals(c.getName())){
                    value = c.getValue();
                    break;
                }
            }
        }

//        String key = "user_"+value;
//        if(redisUtil.hasKey(key)){
//            redisUtil.expire(key,60*10);
//
//            LocalUser user = (LocalUser) redisUtil.get(key);
//            LocalInfo.set(user);
//            return true;
//        }
//
//        throw new RuntimeException("没登录");
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

}