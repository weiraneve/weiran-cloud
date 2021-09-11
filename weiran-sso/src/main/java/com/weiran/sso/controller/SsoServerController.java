package com.weiran.sso.controller;


import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.sso.SaSsoHandle;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.weiran.sso.manager.UserManager;
import com.weiran.sso.model.UserDO;
import org.apache.catalina.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sa-Token-SSO Server端 Controller
 */
@RestController
public class SsoServerController {

    @Autowired
    private UserManager userManager;

    /*
     * SSO-Server端：处理所有SSO相关请求
     *         http://{host}:{port}/sso/auth           -- 单点登录授权地址，接受参数：redirect=授权重定向地址
     *         http://{host}:{port}/sso/doLogin        -- 账号密码登录接口，接受参数：name、pwd
     *         http://{host}:{port}/sso/checkTicket    -- Ticket校验接口（isHttp=true时打开），接受参数：ticket=ticket码、ssoLogoutCall=单点注销回调地址 [可选]
     *         http://{host}:{port}/sso/logout         -- 单点注销地址（isSlo=true时打开），接受参数：loginId=账号id、secretkey=接口调用秘钥
     */
    @RequestMapping("/sso/*")
    public Object ssoRequest() {
        return SaSsoHandle.serverRequest();
    }

    // 配置SSO相关参数
    @Autowired
    private void configSso(SaTokenConfig cfg) {
        cfg.sso
                // 配置：未登录时返回的View
                .setNotLoginView(() -> {
                    String msg = "当前会话在SSO-Server端尚未登录，请先访问 认证中心的路径 /sso/doLogin";
                    return msg;
                })
                // 配置：登录处理函数
                .setDoLoginHandle((name, pwd) -> {
                    UserDO userDO = userManager.getOne(Wrappers.<UserDO>lambdaQuery()
                            .eq(UserDO::getName, name)
                            .eq(UserDO::getPassword, pwd));
                    if (userDO == null) {
                        return SaResult.error("登陆失败，账号不存在");
                    } else {
                        StpUtil.login(SaSecureUtil.md5(name));
                        return SaResult.ok("登录成功！");
                    }
                })
        ;
    }
}
