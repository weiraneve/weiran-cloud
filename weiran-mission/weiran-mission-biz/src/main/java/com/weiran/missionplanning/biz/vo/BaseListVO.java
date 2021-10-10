package com.weiran.missionplanning.biz.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * discription:
 */
@Data
public class BaseListVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<T> list;

    private Long count;
}
