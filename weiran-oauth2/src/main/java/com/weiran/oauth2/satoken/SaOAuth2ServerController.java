package com.weiran.oauth2.satoken;


import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.oauth2.config.SaOAuth2Config;
import cn.dev33.satoken.oauth2.logic.SaOAuth2Handle;
import cn.dev33.satoken.oauth2.logic.SaOAuth2Util;
import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Sa-OAuth2 Server端 控制器
 */
@RestController
public class SaOAuth2ServerController {

    // 处理所有OAuth相关请求
    @RequestMapping("/oauth2/*")
    public Object request() {
        System.out.println("------- 进入请求: " + SaHolder.getRequest().getUrl());
        return SaOAuth2Handle.serverRequest();
    }

    // Sa-OAuth2 定制化配置
    @Autowired
    public void setSaOAuth2Config(SaOAuth2Config cfg) {
        cfg.
            // 配置：未登录时返回的View
            setNotLoginView(() -> {
                String msg = "当前会话在SSO-Server端尚未登录，请先访问"
                + "doLogin登录 "
                + "进行登录之后，开始授权";
                return msg;
            }).
            // 配置：登录处理函数,这里与数据库数据一致 sa 123
            setDoLoginHandle((name, pwd) -> {
                if("sa".equals(name) && "123".equals(pwd)) {
                    StpUtil.login(SaSecureUtil.md5(name));
                    return SaResult.ok();
                }
                return SaResult.error("账号名或密码错误");
            }).
            // 配置：确认授权时返回的View
            setConfirmView((clientId, scope) -> {
                String msg = "应用 " + clientId + " 请求授权：" + scope
                + "请确认：/oauth2/doConfirm?client_id=" + clientId + "&scope=" + scope + "确认授权"
                + "确认之后刷新页面";
                return msg;
            })
        ;
    }

    // 全局异常拦截
    @ExceptionHandler
    public SaResult handlerException(Exception e) {
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }

    // ---------- 开放相关资源接口： Client端根据 Access-Token ，置换相关资源 ------------

    // 获取Userinfo信息：昵称、头像、性别等等
    @RequestMapping("/oauth2/userinfo")
    public SaResult userinfo() {
        // 获取 Access-Token 对应的账号id
        String accessToken = SaHolder.getRequest().getParamNotNull("access_token");
        Object loginId = SaOAuth2Util.getLoginIdByAccessToken(accessToken);
        System.out.println("-------- 此Access-Token对应的账号id: " + loginId);

        // 校验 Access-Token 是否具有权限: userinfo
        SaOAuth2Util.checkScope(accessToken, "userinfo");

        // 模拟账号信息 （真实环境需要查询数据库获取信息）
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("nickname", "weiran");
        map.put("avatar", "https://weiran.ltd/upload/2021/07/logo-1ee0fc59bb4342f39344214800c5442e.png");
        map.put("age", "22");
        map.put("sex", "男");
        map.put("address", "成都市 锦江区");
        return SaResult.data(map);
    }

}
