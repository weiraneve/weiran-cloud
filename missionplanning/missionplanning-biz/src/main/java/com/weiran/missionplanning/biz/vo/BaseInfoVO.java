package com.weiran.missionplanning.biz.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * discription:
 */
@Data
public class BaseInfoVO<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T info;
}
