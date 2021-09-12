package com.weiran.ssoA.satoken;


import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * [Sa-Token 权限认证] 配置类
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    /**
     * 全局SSO过滤器
     */
    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
        .addInclude("/**")
        .addExclude("/sso/*", "/favicon.ico", "/isOrLogin")
        .setAuth(r -> {
            SaRouter.match("/main", () -> StpUtil.checkPermissionOr("test", "admin"));
        })
        ;
    }
}
