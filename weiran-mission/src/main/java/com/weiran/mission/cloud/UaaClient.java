package com.weiran.mission.cloud;


import com.weiran.mission.cloud.fallback.UaaClientFallback;
import com.weiran.mission.config.FeignConfig;
import com.weiran.mission.obj.AjaxJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "weiran-uaa", fallback = UaaClientFallback.class, configuration = FeignConfig.class)
public interface UaaClient {

    @RequestMapping(value = "/test/tokenInfo")
    AjaxJson tokenInfo();

    @RequestMapping(value = "/test/tokenInfo01")
    boolean tokenInfo01();

}
