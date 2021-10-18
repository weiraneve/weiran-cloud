package com.weiran.uaa.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.weiran.uaa.service.UserService;
import com.weiran.uaa.util.AjaxResult;
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
