package com.weiran.uaa.satoken;



import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * [Sa-Token 权限认证] 配置类
 * Uaa模块负责登陆认证，网管负责鉴权，这里过滤器不做配置
 */
//@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    /**
     * 注册 [Sa-Token全局过滤器]
     */
    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter();

    }

    /**
     * 注册sa-token的拦截器，打开注解式鉴权功能
     * 但默认的拦截器只能用在Controller层里，这里可以使用AOP注解鉴权便可以写在任意层级。
     * 可以注册开启路由式鉴权,并且自定义权限验证规则
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor());
    }

}
