package com.weiran.mission.controller;

import com.weiran.mission.cloud.UaaClient;
import com.weiran.mission.obj.AjaxJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/test")
@RestController
@Slf4j
public class TestController {

    @Resource
    private UaaClient uaaClient;

    @GetMapping(value = "/hasAdmin")
    public String getStr() {
        return "网关成功对misoon模块鉴权!!!";
    }

    // Feign 调用 uaa模块接口，返回封装返回体
    @RequestMapping("/tokenInfo")
    public AjaxJson getUaaAj() {
        return uaaClient.tokenInfo();
    }

    // Feign 调用 uaa模块接口，返回简单的布尔值
    @RequestMapping("/tokenInfo01")
    public boolean getUaaAj01() {
        return uaaClient.tokenInfo01();
    }

    @RequestMapping("/say")
    public AjaxJson say() {
        return new AjaxJson().setMsg("测试Logstash");
    }

    @RequestMapping("/print")
    public Map index() throws UnknownHostException {
        Map<String, Object> map = new HashMap<>();
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = localHost.getHostName();
        String hostAddress = localHost.getHostAddress();
        map.put("主机名",hostName);
        map.put("主机地址",hostAddress);
        log.info("测试日志");
        return map;
    }
}
