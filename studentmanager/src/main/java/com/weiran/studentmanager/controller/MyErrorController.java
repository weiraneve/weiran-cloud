package com.weiran.studentmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 实现异常统一处理接口处理404、500等错误实现跳转指定页面
 */
@Controller
public class MyErrorController implements ErrorController {

    @Autowired
    HttpServletRequest request;

    @Override
    @RequestMapping(value = "/error", produces = {"application/json;charset=UTF-8"})
    public String getErrorPath() { // 这里的路径只能写error
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return "/error";
        }
        switch (statusCode) {
            case 404:
                return "/error"; // 从Controller实现，找不到的页面404重定向到登陆界面，
            case 500:
                return "/error";
            default:
                 return "/error"; // 问题是这里返回的是静态html，路由过滤器鉴权不能这样
        }
    }
}

