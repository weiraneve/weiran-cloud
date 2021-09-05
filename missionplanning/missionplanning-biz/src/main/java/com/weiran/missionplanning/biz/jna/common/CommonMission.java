package com.weiran.missionplanning.biz.jna.common;

import com.weiran.missionplanning.biz.jna.dto.MissionDTO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/7/2 0002 9:59
 */
public class CommonMission {

    /**
     * 用户工程
     */
    public static Map<String, MissionDTO> USER_MISSION_INFO = new ConcurrentHashMap<String, MissionDTO>();

    /**
     * 计划状态 1 生成中 2 生成完成
     */
    public static Map<Long, Integer> PLAN_STATE = new ConcurrentHashMap<Long, Integer>();
}
