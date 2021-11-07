package com.weiran.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.weiran.sentinel.domain.CommonResult;

/**
 * 用于自定义限流处理逻辑
 */
public class CustomBlockHandler {

    public CommonResult handleException(BlockException exception){
        return new CommonResult("自定义限流信息",200);
    }
}
