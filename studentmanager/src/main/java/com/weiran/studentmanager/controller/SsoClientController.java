package com.weiran.studentmanager.controller;


import cn.dev33.satoken.sso.SaSsoHandle;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sa-Token-SSO Client端 Controller
 */
@RestController
public class SsoClientController {

    // 首页
    @RequestMapping("/ssoislogin")
    public String index() {
        String str = "Sa-Token SSO-Client 应用端 \n" +
                "当前会话是否登录：" + StpUtil.isLogin();

        return str;
    }

    /*
     * SSO-Client端：处理所有SSO相关请求
     *         http://{host}:{port}/sso/login          -- Client端登录地址，接受参数：back=登录后的跳转地址
     *         http://{host}:{port}/sso/logout         -- Client端单点注销地址（isSlo=true时打开），接受参数：back=注销后的跳转地址
     *         http://{host}:{port}/sso/logoutCall     -- Client端单点注销回调地址（isSlo=true时打开），此接口为框架回调，开发者无需关心
     */
    @RequestMapping("/sso/*")
    public Object ssoRequest() {
        return SaSsoHandle.clientRequest();
    }

}
