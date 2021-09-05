package com.weiran.missionplanning.biz.cloud.fallback;

import com.weiran.missionplanning.biz.cloud.UssoClient;
import org.springframework.stereotype.Component;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/4/19 0019 18:19
 */
@Component
public class UssoClientFallback implements UssoClient {

    @Override
    public boolean judgeEnterpriseUser(Long userId) {
        return false;
    }
}
