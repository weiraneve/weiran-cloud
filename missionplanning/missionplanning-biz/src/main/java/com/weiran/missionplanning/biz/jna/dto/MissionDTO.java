package com.weiran.missionplanning.biz.jna.dto;

import com.weiran.missionplanning.biz.jna.domian.ComplationCallback;
import com.sun.jna.Pointer;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/7/2 0002 9:43
 */
@Data
public class MissionDTO {

    /**
     * 账户信息
     */
    private Pointer hAcc;

    /**
     * 解决方案
     */
    private List<Pointer> solutions;

    /**
     * 人员
     */
    private Pointer[] hoperators;

    /**
     * 站点
     */
    private Pointer[] hstations;

    /**
     * 飞行平台
     */
    private Pointer[] hVehicles;

    /**
     * 所选解决方案
     */
    private Pointer hcomm;

    /**
     * 工程
     */
    private Pointer hProj;

    /**
     * 工程人员
     */
    private Pointer[] hprojectOperators;

    /**
     * 工程站点
     */
    private Pointer[] hprojectStations;

    /**
     * 工程飞行平台
     */
    private Pointer[] hprojectVehicles;

    /**
     * 工程目标
     */
    private Pointer[] hprojectTarget;

    /**
     * 工单
     */
    private Pointer[] orders;

    private Pointer[] hplayers;

    private Pointer zoneh;

    /**
     * 任务人员
     */
    private Pointer[] selectHoperators;

    /**
     * 任务站点
     */
    private Pointer[] selectHstations;

    /**
     * 任务飞行平台
     */
    private Pointer[] selectHvehicles;

    /**
     * 航线规划回调
     */
    private ComplationCallback callback;

}
