package com.weiran.missionplanning.biz.jna.common;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/7/12 0012 18:22
 */
public class OrderState {

    /**
     *
     */
    public static int ORDER_UNKNOWN = -1;

    /**
     * 编辑中
     */
    public static int ORDER_EDITING = 0;

    /**
     * 进行中
     */
    public static int ORDER_EXECUTING = 1;

    /**
     *
     */
    public static int ORDER_OVER = 2;
}
