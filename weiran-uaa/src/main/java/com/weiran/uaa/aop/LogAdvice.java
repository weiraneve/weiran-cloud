package com.weiran.uaa.aop;

import com.weiran.uaa.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogAdvice.java
 * @Description 登陆日志切点
 */

@Aspect
@Component
@Slf4j
public class LogAdvice {

    //定义一个切面。括号内写入自定义注解的路径
    @Pointcut("@annotation(com.weiran.uaa.annotation.LogAnnotation)")
    private void LogCheck(){}

    /**
     * args 传入目标函数的参数
     *
     *
     */
    @AfterReturning(value = "LogCheck()",returning = "ajaxResult") //这里返回参数必须与下文一致
    public void LogCheckFirst(JoinPoint joinPoint,Object ajaxResult) {
        
//        Object[] objects = joinPoint.getArgs();//获取请求参数

        boolean success = ((AjaxResult) ajaxResult).getSuccess();
        String name = ((AjaxResult) ajaxResult).getName();
        String type = ((AjaxResult) ajaxResult).getType();
        if (success) {
            switch (type) {
                case "1": {
                    log.info("管理员" + name + "登陆成功");
                    break;
                }
                case "2": {
                    log.info("学生" + name + "登陆成功");
                    break;
                }
                case "3": {
                    log.info("教师" + name + "登陆成功");
                    break;
                }
            }
        } else {
            switch (type) {
                case "1": {
                    log.info("管理员" + name + "登陆失败");
                    break;
                }
                case "2": {
                    log.info("学生" + name + "登陆失败");
                    break;
                }
                case "3": {
                    log.info("教师" + name + "登陆失败");
                    break;
                }
            }
        }
    }

}
