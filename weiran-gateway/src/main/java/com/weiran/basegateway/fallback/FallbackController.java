package com.weiran.basegateway.fallback;

import com.weiran.basegateway.model.ErrorCode;
import com.weiran.basegateway.model.Msg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * discription:
 */
@RestController
public class FallbackController {

    /**
     * 全局服务降级处理返回
     * @return
     */
    @RequestMapping("/defaultFallback")
    public Msg fallback() {
        Msg msg = new Msg();
        msg.setCode(ErrorCode.MICRO_SERVICE_UNAVAILABLE);
        msg.setMsg("系统更新中，请稍后再试");
        return msg;
    }
}
