package com.weiran.uaa.controller;

import cn.dev33.satoken.annotation.*;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.weiran.uaa.obj.AjaxJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class TestController {

    // 测试注解式鉴权 ， 需要注册配置类
    @SaCheckLogin						// 注解式鉴权：当前会话必须登录才能通过
    @SaCheckRole("admin")			// 注解式鉴权：当前会话必须具有指定角色标识才能通过
    @SaCheckPermission("admin")		// 注解式鉴权：当前会话必须具有指定权限才能通过
    @RequestMapping("atCheck00")
    public AjaxJson atCheck() {
        System.out.println("======================= 进入方法，测试注解鉴权接口 ========================= ");
        System.out.println("只有通过注解鉴权，才能进入此方法");
        return AjaxJson.getSuccess("成功通过注解鉴权00");
    }

    @RequestMapping("atCheck01")
    @SaCheckPermission(value = {"student", "teacher", "admin"}, mode = SaMode.OR)  // 注解式鉴权：只要具有其中一个权限即可通过校验
    public AjaxJson atJurOr() {
        return AjaxJson.getSuccessData("成功通过注解鉴权01");
    }

    @RequestMapping("tokenInfo")
    public AjaxJson tokenInfo() {
        System.out.println("======================= 进入方法，打印当前token信息 ========================= ");
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        System.out.println(tokenInfo);
        if (!StpUtil.hasPermission("admin")) {
            System.out.println("没有admin权限");
        }
        if (StpUtil.isLogin()) {
            System.out.println("已经登陆");
        } else {
            System.out.println("没有登陆");
        }
        return AjaxJson.getSuccessData(tokenInfo);
    }

    @RequestMapping("tokenInfo01")
    public boolean tokenInfo01() {
        return true;
    }

    // 以注解方式启用 Basic 校验
    @SaCheckBasic(account = "sa:123456")
    @RequestMapping("/testbasic")
    public AjaxJson testBasic() {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setCode(200);
        ajaxJson.setMsg("注解方式启用 Basic 校验成功！");

        return ajaxJson;
    }

}
