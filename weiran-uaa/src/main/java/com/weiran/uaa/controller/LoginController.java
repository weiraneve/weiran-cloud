package com.weiran.uaa.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.weiran.uaa.service.UserService;
import com.weiran.uaa.obj.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName LoginController.java
 * 暂时改为前后端解耦，只写接口的情况
 * @Description 登陆
 */
@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 网关统一鉴权后的页面
     */
    @RequestMapping("/gatewayTest")
    public String getGat() {
        return "/gatewayTest";
    }


    /**
     * 鉴权后的主页面
     */
    @RequestMapping("/main")
    public String getMain() {
        return "/main";
    }

    /**
     * @description 登陆表单提交、校验
     */
    @RequestMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public AjaxResult submitLogin(String username, String password){
        AjaxResult ajaxResult = userService.login(username, password);
        return ajaxResult;
    }

    /**
     * @description 登出
     */
    @RequestMapping("/logout")
    @ResponseBody
    public AjaxResult logout() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setMessage("会话已经注销");
        StpUtil.logout();
        return ajaxResult;
    }

    /**
     *  查询登录状态，浏览器访问
     */
    @RequestMapping("/isOrLogin")
    @ResponseBody
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}
