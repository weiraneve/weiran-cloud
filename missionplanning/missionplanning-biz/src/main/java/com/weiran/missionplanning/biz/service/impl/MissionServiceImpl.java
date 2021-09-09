package com.weiran.missionplanning.biz.service.impl;

import com.weiran.common.obj.ResultMsgObj;
import com.weiran.missionplanning.biz.service.MissionService;
import org.springframework.stereotype.Service;


/**
 * discription:
 */

@Service("missionService")
public class MissionServiceImpl implements MissionService {

    @Override
    public ResultMsgObj getMissionBaseInfo() {
        ResultMsgObj resultMsgObj = new ResultMsgObj();
        resultMsgObj.setMsg("MisiionPlanning模块成功调用");

        return resultMsgObj;
    }

}
