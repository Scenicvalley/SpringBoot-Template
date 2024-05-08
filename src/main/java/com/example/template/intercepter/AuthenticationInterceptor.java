package com.example.template.intercepter;

import com.alibaba.fastjson.JSONObject;
import com.example.template.pojo.Result;
import com.example.template.util.LoginRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import com.example.template.util.RedisUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author xiao yang
 * @Description: 请求合法性校验
 * @date 2023/1/1412:38
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    RedisUtil redisUtil;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationInterceptor.class);
    //定义请求头里面的字段名
    private static final String AUTHORIZATION = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            LOGGER.info("没有映射到方法，则无需检查直接通过");
            return true;
        }
        HandlerMethod heHandlerMethod = (HandlerMethod) handler;
        JSONObject rs=new Result().responseResult(400,"token失效");
        Method method = heHandlerMethod.getMethod();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
        //有LoginRequired注解，不需要认证
        if (loginRequired != null) {
            return true;
        }
        String token = request.getHeader(AUTHORIZATION);
        System.out.println("token的值： "+token);
        if (token != null) {
            boolean falg = redisUtil.hasKey(token);
            System.out.println("flag的值: " + falg);
            if (falg) {
                return true;
            } else {
                PrintWriter writer = response.getWriter();
                System.out.println("token失效");
                writer.append(rs.toJSONString());
            }
        }
        return  false;
    }
}
