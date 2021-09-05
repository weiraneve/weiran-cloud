package com.weiran.missionplanning.biz.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description：
 * @Author: aoxiaoqin@weiran.com
 * @Date: 2021/6/24 17:12
 **/
@Data
public class BasePlanVO {

    /**
     * 计划id
     */
    @ApiModelProperty(value = "计划id", required = true)
    private Long planId;

    /**
     * 计划名称
     */
    @ApiModelProperty(value = "计划名称", required = true)
    private String planName;
}
