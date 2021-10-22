package com.weiran.gateway.satoken;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.weiran.gateway.util.AjaxJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关统一鉴权
 */
@Configuration
public class SaTokenConfigure {

    /**
     * 注册 [sa-token全局过滤器]
     * 网关统一鉴权
     */
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                .addInclude("/**")
                .addExclude("/favicon.ico", "/uaa/logout", "/uaa/isOrLogin")
                .setAuth(r -> {
                     System.out.println("---------- 网关全局认证");
                    // 登录验证 -- 拦截所有路由，并排除登陆接口 用于开放登录
                    SaRouter.match("/**", "/uaa/login", () -> StpUtil.checkLogin());
                    // 权限认证 -- 不同模块, 校验不同权限
                    SaRouter.match("/mission/**", () -> StpUtil.checkPermissionOr("admin"));

                })
                .setError(e -> {
                     System.out.println("---------- 网关全局异常 ");
                    return AjaxJson.getError(e.getMessage());
                })
                // 前置函数：在每次认证函数之前执行
                .setBeforeAuth(r -> {
                    // ---------- 设置跨域响应头 ----------
                    SaHolder.getResponse()
                            // 允许指定域访问跨域资源
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
                            // 有效时间
                            .setHeader("Access-Control-Max-Age", "3600")
                            // 允许的header参数
                            .setHeader("Access-Control-Allow-Headers", "x-requested-with,satoken");

                    // 如果是预检请求，直接返回
                    if ("OPTIONS".equals(SaHolder.getRequest().getMethod())) {
                        System.out.println("=======================浏览器发来了OPTIONS预检请求==========");
                        SaRouter.back();
                    }
                })
                ;
    }

}

