package com.weiran.ssoA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/main")
    public String getMain() {
        return "/main";
    }
}
