package com.weiran.mission.controller;

import com.weiran.mission.cloud.UaaClient;
import com.weiran.mission.obj.AjaxJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/test")
@RestController
public class TestController {

    @Resource
    private UaaClient uaaClient;

    @GetMapping(value = "/hasAdmin")
    public String getStr() {
        return "网关成功对misoon模块鉴权!!!";
    }

    @RequestMapping("/tokenInfo")
    public AjaxJson getUaaAj() {
        return uaaClient.tokenInfo();
    }

    @RequestMapping("/tokenInfo01")
    public boolean getUaaAj01() {
        return uaaClient.tokenInfo01();
    }
}
