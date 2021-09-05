package com.weiran.studentmanager.controller;


import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.weiran.studentmanager.manager.UserManager;
import com.weiran.studentmanager.model.UserDO;
import com.weiran.studentmanager.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName LoginController.java
 * 暂时改为前后端解耦，只写接口的情况
 * @Description 登陆
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserManager userManager;

    /**
     * @description 登陆表单提交、校验
     */
    @RequestMapping("/login")
    public AjaxResult submitLogin(String username, String password){
        AjaxResult ajaxResult = new AjaxResult();
        if (StringUtils.isEmpty(username)) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("请填写用户名");
            ajaxResult.setCode(ajaxResult.CODE_ERROR);
            return ajaxResult;
        }
        if (StringUtils.isEmpty(password)) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("请填写密码");
            ajaxResult.setCode(ajaxResult.CODE_ERROR);
            return ajaxResult;
        }

        // 身份验证
        UserDO userDO = userManager.getOne(Wrappers.<UserDO>lambdaQuery()
                .eq(UserDO::getName, username)
                .eq(UserDO::getPassword, password));
        if (userDO == null) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("用户名或密码错误");
            ajaxResult.setCode(ajaxResult.CODE_ERROR);
            return ajaxResult;
        }

        StpUtil.login(SaSecureUtil.md5(username)); // 这里有个bug，不能用StpUseUtil封装的工具类，否则有bug

        if (!StpUtil.hasRole("student")) {
            ajaxResult.setSuccess(false);
            ajaxResult.setCode(ajaxResult.CODE_WARNING);
            ajaxResult.setMessage("角色认证有问题");
            log.info("角色认证有问题");
        }
        if (!StpUtil.hasPermission("student")) {
            ajaxResult.setSuccess(false);
            ajaxResult.setCode(ajaxResult.CODE_WARNING);
            ajaxResult.setMessage("权限认证有问题");
            log.info("权限认证有问题");
        }

        ajaxResult.setCode(ajaxResult.CODE_SUCCESS);
        ajaxResult.setSuccess(true);
        ajaxResult.setMessage(username + "登陆成功");

        return ajaxResult;
    }

    /**
     * @description 登出
     */
    @RequestMapping("/logout")
    public String logout() {
        StpUtil.logout(); // 会话注销
        return "login";
    }

    /**
     *  查询登录状态，浏览器访问
     */
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    /**
      * @description 显示验证码
      */
//    @GetMapping("/checkCode")
//    public void generateCpacha(HttpServletRequest request, HttpServletResponse response,
//                               @RequestParam(value="vl",defaultValue="4",required=false) Integer vl,
//                               @RequestParam(value="w",defaultValue="110",required=false) Integer w,
//                               @RequestParam(value="h",defaultValue="39",required=false) Integer h){
//        CpachaUtil cpachaUtil = new CpachaUtil(vl, w, h);
//        String generatorVCode = cpachaUtil.generatorVCode();
//        request.getSession().setAttribute("code", generatorVCode);
//        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
//        try {
//            ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    //验证功能
//        if(StringUtils.isEmpty(code)){
//            ajaxResult.setSuccess(false);
//            ajaxResult.setMessage("请填验证码");
//            return ajaxResult;
//        }
//        if(StringUtils.isEmpty(session.getAttribute("code"))){
//            ajaxResult.setSuccess(false);
//            ajaxResult.setMessage("会话时间过长，请刷新");
//            return ajaxResult;
//        }
//        else{
//            if(!code.equalsIgnoreCase((String) session.getAttribute("code"))){
//                ajaxResult.setSuccess(false);
//                ajaxResult.setMessage("验证码错误");
//                return ajaxResult;
//            }
//        }
}
