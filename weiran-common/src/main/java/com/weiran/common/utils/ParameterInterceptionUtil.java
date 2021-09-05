package com.weiran.common.utils;

import com.jouav.jouavcloud.common.code.CodeDesc;
import com.jouav.jouavcloud.common.obj.ResultMsgObj;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

/**
 * discription: 参数拦截
 *
 * @author luobin@jouav.com
 * @date 2020/8/19 0019 17:20
 */
public class ParameterInterceptionUtil {

    /**
     * 参数拦截错误返回
     * @param bindingResult
     * @return
     */
    public static ResultMsgObj interceptResult(BindingResult bindingResult) {
        ResultMsgObj result = new ResultMsgObj<>();
        Map<String, Object> data = new HashMap<>();
        Map<String, String> singleMap = new HashMap<>();
        result.setCode(CodeDesc.FAILURE.getCode());
        singleMap.put(bindingResult.getFieldError().getField(), bindingResult.getFieldError().getDefaultMessage());
        data.put("error", singleMap);
        result.setData(data);
        result.setMsg(bindingResult.getFieldError().getDefaultMessage());
        return result;
    }

    /**
     * 参数校验拦截
     * @return
     */
    public static ResultMsgObj interceptCheck(String filed, String msg) {
        ResultMsgObj result = new ResultMsgObj<>();
        Map<String, Object> data = new HashMap<>();
        Map<String, String> singleMap = new HashMap<>();
        result.setCode(CodeDesc.FAILURE.getCode());
        singleMap.put(filed, msg);
        data.put("error", singleMap);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
}
