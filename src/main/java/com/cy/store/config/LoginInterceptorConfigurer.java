package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**处理拦截器的注册*/
@Configuration //加载当前的拦截器进行注册
public class LoginInterceptorConfigurer implements WebMvcConfigurer {


    /**用来配置拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建自定义拦截器的对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        /**这里有一个向上转型 可以理解为将子类类型的对象转换为父类类型的对象，即把子类类型的对象直接赋值给父类类型的对象，进而实现按照父类描述子类的效果

         * */

        //添加白名单,存放在List集合，以后有需要再添加
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");



        //拦截器的注册
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);

    }
}
