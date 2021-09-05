//package com.weiran.studentmanager.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.weiran.studentmanager.mapper.AdminMapper;
//import com.weiran.studentmanager.util.AjaxResult;
//import com.weiran.studentmanager.util.Encrypt;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
///**
// * @ClassName RegistryController.java
// * @Description 注册管理员
// */
//@Controller
//@Slf4j
//public class RegistryController {
//
//    @Autowired
//    private AdminMapper adminMapper;
//
//    /**
//     * @description 跳转注册页面
//     */
//    @GetMapping("/registry")
//    public String registry () {
//        return "registry";
//    }
//
//    /**
//     * @description 注册表单提交、校验
//     */
//    @PostMapping("/registry")
//    @ResponseBody
//    public AjaxResult submitLogin(String username, String password1,
//                                  String password2) {
//        AjaxResult ajaxResult = new AjaxResult();
//        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
//        adminQueryWrapper.eq("username",username);
//        Admin adminQuery = adminMapper.selectOne(adminQueryWrapper);
//        if (!StringUtils.isEmpty(adminQuery)) {
//            ajaxResult.setSuccess(false);
//            ajaxResult.setMessage("请正确填写非重复的管理者名");
//            return ajaxResult;
//        }
//        else if (StringUtils.isEmpty(password1)) {
//            ajaxResult.setSuccess(false);
//            ajaxResult.setMessage("请填写注册密码");
//            return ajaxResult;
//        }
//        else if (StringUtils.isEmpty(password2)|| !password1.equals(password2))
//        {
//            ajaxResult.setSuccess(false);
//            ajaxResult.setMessage("请正确填写重复密码");
//            return ajaxResult;
//        }
//
//        Admin admin = new Admin();
//        admin.setUsername(username);
//        String password = Encrypt.md5(password1); //admin的密码注册后用md5加密，储存在数据库中
//        admin.setPassword(password);
//        if(adminMapper.insert(admin) == 0){
//            ajaxResult.setSuccess(false);
//            ajaxResult.setMessage("注册失败，请重新检查是否正确填写");
//            return ajaxResult;
//        }
//        ajaxResult.setSuccess(true);
//        ajaxResult.setMessage("注册成功");
//        log.info("管理员"+username+"注册成功"); //日志info输出
//        return ajaxResult;
//    }
////
////    /**
////     * @description 显示验证码
////     */
////    @GetMapping("/checkCode")
////    public void generateCpacha(HttpServletRequest request, HttpServletResponse response,
////                               @RequestParam(value="vl",defaultValue="4",required=false) Integer vl,
////                               @RequestParam(value="w",defaultValue="110",required=false) Integer w,
////                               @RequestParam(value="h",defaultValue="39",required=false) Integer h){
////        CpachaUtil cpachaUtil = new CpachaUtil(vl, w, h);
////        String generatorVCode = cpachaUtil.generatorVCode();
////        request.getSession().setAttribute("code", generatorVCode);
////        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
////        try {
////            ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
//
//
//}
