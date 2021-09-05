package com.weiran.missionplanning.biz.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * discription:
 *
 * @author wujinzhu@weiran.com
 * @date 2021/4/7 15:12
 */
@Data
public class BaseListVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<T> list;

    private Long count;
}
