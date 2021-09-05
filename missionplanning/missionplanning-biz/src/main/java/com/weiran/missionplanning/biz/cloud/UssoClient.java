package com.weiran.missionplanning.biz.cloud;

import com.weiran.common.configer.FeignConfiger;
import com.weiran.missionplanning.biz.cloud.fallback.UssoClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/4/19 0019 18:19
 */
@FeignClient(value = "jouav-cloud-uaa", fallback = UssoClientFallback.class, configuration = FeignConfiger.class)
public interface UssoClient {


    /**
     * 判断是否是企业账号
     * @param userId
     * @return
     */
    @GetMapping("/v1/enterpriseUser/judgeEnterpriseUser")
    boolean judgeEnterpriseUser(@RequestParam("userId") Long userId);
}
