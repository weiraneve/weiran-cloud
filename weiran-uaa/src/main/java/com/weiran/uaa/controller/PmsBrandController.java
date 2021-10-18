package com.weiran.uaa.controller;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;
import com.weiran.uaa.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * 在项目中添加一个有远程调用接口，看看能不能收集到请求调用链路
 */
@Api(tags = "RPC-Controller", description = "远程调用，调试是否能收集到请求调用链路")
@Controller
@RequestMapping("/RPC")
public class PmsBrandController {

    @ApiOperation("调用获取信息")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult remoteListAll() {
        AjaxResult ajaxResult = new AjaxResult();
        //模拟耗时操作
        ThreadUtil.sleep(1, TimeUnit.SECONDS);
        //远程调用获取数据
        String response = HttpUtil.get("http://localhost:8088/RPC/test");
        ajaxResult.setMessage("获取成功");
        return ajaxResult;
    }
}
