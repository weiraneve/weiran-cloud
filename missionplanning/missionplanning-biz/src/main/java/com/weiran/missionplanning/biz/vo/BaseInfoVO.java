package com.weiran.missionplanning.biz.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * discription:
 *
 * @author wujinzhu@weiran.com
 * @date 2021/4/7 15:13
 */
@Data
public class BaseInfoVO<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T info;
}
