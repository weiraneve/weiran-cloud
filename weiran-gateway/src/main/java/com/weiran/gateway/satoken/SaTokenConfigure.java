//package com.weiran.gateway.satoken;
//
//
//import cn.dev33.satoken.reactor.filter.SaReactorFilter;
//import cn.dev33.satoken.router.SaRouter;
//import cn.dev33.satoken.stp.StpUtil;
//import cn.dev33.satoken.util.SaResult;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * [Sa-Token 权限认证] 配置类
// */
//@Configuration
//public class SaTokenConfigure {
//    // 注册 Sa-Token全局过滤器
//    @Bean
//    public SaReactorFilter getSaReactorFilter() {
//        return new SaReactorFilter()
//                // 拦截地址
//                .addInclude("/**")
//                // 开放地址
//                .addExclude("/favicon.ico")
//                // 鉴权方法：每次访问进入
//                .setAuth(r -> {
//                    // 登录验证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
//                    SaRouter.match("/**", "/user/doLogin", () -> StpUtil.checkLogin());
//
//                    // 权限认证 -- 不同模块, 校验不同权限
//                    SaRouter.match("/user/**", () -> StpUtil.checkPermission("user"));
//                    SaRouter.match("/admin/**", () -> StpUtil.checkPermission("admin"));
//                    SaRouter.match("/goods/**", () -> StpUtil.checkPermission("goods"));
//
//                    // ...
//                })
//                // 异常处理方法：每次setAuth函数出现异常时进入
//                .setError(e -> {
//                    return SaResult.error(e.getMessage());
//                })
//                ;
//    }
//}
