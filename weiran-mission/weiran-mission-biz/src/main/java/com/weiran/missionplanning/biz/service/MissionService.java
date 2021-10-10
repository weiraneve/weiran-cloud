package com.weiran.missionplanning.biz.service;

import com.weiran.common.obj.ResultMsgObj;
import com.weiran.missionplanning.biz.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * discription:
 */
@Service
public interface MissionService {

    ResultMsgObj getMissionBaseInfo();
}
