package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义一个拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局session对象中是否有uid数据，如果有则放行，如果没有重定向到登录界面
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器（url+controller映射）
     * @return 如果返回值为true表示放行当前请求，为flase表示拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpServletRequest对象来获取session对象
//        因为只判断是不是为空，所以不用判断数据类型，用Object即可
        Object obj = request.getSession().getAttribute("uid");
        if(obj==null){
//            说明用户没有登陆过系统，则重定向到login.html页面
            response.sendRedirect("/web/login.html");
            return false;
        }
//        放行请求
        return true;
    }
}
