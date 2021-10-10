package com.weiran.missionplanning.api.controller;

import com.weiran.common.obj.ResultMsgObj;
import com.weiran.missionplanning.biz.service.MissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/mission")
@Api(tags = "【新建任务模块】")
public class MissionController {

    @Autowired
    private MissionService missionService;

    /**
     * 任务详情
     *
     * @return
     */
    @ApiOperation(value = "获取任务详情")
    @GetMapping("/info")
    public ResultMsgObj missionInfo() {
        return missionService.getMissionBaseInfo();
    }


}
