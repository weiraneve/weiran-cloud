package com.weiran.mission.cloud.fallback;

import com.weiran.mission.cloud.UaaClient;
import com.weiran.mission.obj.AjaxJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 服务降级实现类
 *
 * 在网络请求时，可能会出现异常请求，如果还想再异常情况下使系统可用，下面我们为接口添加一个服务降级实现类。
 * 这里第一个方法没有回调服务降级则无法使用，与封装返回类有关。
 */
@Component
@Slf4j
public class UaaClientFallback implements UaaClient {

    @Override
    public AjaxJson tokenInfo() {
        log.warn("=============== tokenInfo方法调用失败，服务被降级");
        return null;
    }

    @Override
    public boolean tokenInfo01() {
        log.warn("=============== tokenInfo01方法调用失败，服务被降级");
        return false;
    }
}
