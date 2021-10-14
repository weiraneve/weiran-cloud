package com.weiran.studentmanager.satoken;


import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.weiran.studentmanager.util.AjaxJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * [Sa-Token 权限认证] 配置类
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    /**
     * 注册 [Sa-Token全局过滤器]
     */
    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                // 指定 拦截路由 与 放行路由
                .addInclude("/**")
                .addExclude("/favicon.ico", "/login", "/isOrLogin", "/actuator/**")
                // 认证函数: 每次请求执行
                .setAuth(r -> {
                    System.out.println("---------- 进入Sa-Token全局认证 -----------");
                    // 登录验证 -- 拦截所有路由，并排除login接口用于开放登录，这里与后面重定向冲突，如果不注释就无法使用重定向功能，并且重定向后error的404配置也没有必要了
//                    SaRouter.match("/**", "/login", () -> StpUtil.checkLogin());
                    // 如果没有登陆则重定向到登陆界面，并且过滤器一定要排除login接口，否则一直重定向
                    SaRouter.match("/main", () -> StpUtil.checkPermissionOr("admin", "teacher"));
                    if(StpUtil.isLogin() == false) {
                        System.out.println("没有进入登陆界面，重定向到登陆界面");
                        SaHolder.getResponse().redirect("login");
                        SaRouter.back();
                        // 如果不用重定向，也可以与前端约定好，code=401时代表会话未登录
//                        SaRouter.back(SaResult.ok().setCode(401));
                    }
                })
                // 异常处理函数：每次认证函数发生异常时执行此函数
                .setError(e -> {
                    System.out.println("---------- 进入Sa-Token异常处理 -----------");
                    System.out.println(AjaxJson.getError(e.getMessage()));
                    return AjaxJson.getError(e.getMessage());
                })
                // 前置函数：在每次认证函数之前执行
                .setBeforeAuth(r -> {
                    // ---------- 设置一些安全响应头 ----------
                    SaHolder.getResponse()
                            // 服务器名称
                            .setServer("server")
                            // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
                            .setHeader("X-Frame-Options", "SAMEORIGIN")
                            // 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
                            .setHeader("X-XSS-Protection", "1; mode=block")
                            // 禁用浏览器内容嗅探
                            .setHeader("X-Content-Type-Options", "nosniff")
                    ;
                })
                ;
    }

    /**
     * 注册sa-token的拦截器，打开注解式鉴权功能
     * 但默认的拦截器只能用在Controller层里，这里可以使用AOP注解鉴权便可以写在任意层级。
     * 可以注册开启路由式鉴权,并且自定义权限验证规则
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login");

//        // 注册路由拦截器，自定义验证规则
//        registry.addInterceptor(new SaRouteInterceptor((req, res, handler) -> {
//            // 登录验证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
//            SaRouter.match("/**", "/user/doLogin", () -> StpUtil.checkLogin());
//            // 登录验证 -- 排除多个路径
//            SaRouter.match(Arrays.asList("/**"), Arrays.asList("/user/doLogin", "/user/reg"), () -> StpUtil.checkLogin());
//            // 角色认证 -- 拦截以 admin 开头的路由，必须具备[admin]角色或者[super-admin]角色才可以通过认证
//            SaRouter.match("/admin/**", () -> StpUtil.checkRoleOr("admin", "super-admin"));
//            // 权限认证 -- 不同模块, 校验不同权限
//            SaRouter.match("/admin/**", () -> StpUtil.checkPermission("admin"));
//            // 匹配 restful 风格路由
//            SaRouter.match("/article/get/{id}", () -> StpUtil.checkPermission("article"));
//            // 检查请求方式
//            SaRouter.match("/notice/**", () -> {
//                if(req.getMethod().equals(HttpMethod.GET.toString())) {
//                    StpUtil.checkPermission("notice");
//                }
//            });
//            // 提前退出 (执行SaRouter.stop()后会直接退出匹配链)
//            SaRouter.match("/test/back", () -> SaRouter.stop());
//            // 在多账号模式下，可以使用任意StpUtil进行校验
//            SaRouter.match("/user/**", () -> StpUtil.checkLogin());
//        })).addPathPatterns("/**");
    }

}
