package com.weiran.missionplanning.biz.jna.common;

/**
 * @description：
 * @Author: aoxiaoqin@weiran.com
 * @Date: 2021/7/9 10:43
 **/
public class WaypointType {
    /**
     *  -1为常规类型
     */
    public static int WPT_COMMON = -1;

    /**
     *  0为逆时针绕点盘旋（该航路点为中心点）
     */
    public static int WPT_ORBIT = 0;

    /**
     *  1为顺时针绕点盘旋（该航路点为中心点）
     */
    public static int WPT_ORBIT_RIGHT = 1;

    /**
     * 2为逆时针过点盘旋（该航路点为切点）
     */
    public static int WPT_ORBIT_TANGENT = 2;

    /**
     *  3为顺时针过点盘旋（该航路点为切点）
     */
    public static int WPT_ORBIT_TANGENT_RIGHT = 3;

    /**
     * 4为逆时针过高盘旋
     */
    public static int WPT_ORBIT_ABOVE = 4;

    /**
     * 5为顺时针过高盘旋
     */
    public static int WPT_ORBIT_ABOVE_RIGHT = 5;

    /**
     * 6为逆时针过低盘旋
     */
    public static int WPT_ORBIT_BELOW = 6;

    /**
     * 7为顺时针过低盘旋
     */
    public static int WPT_ORBIT_BELOW_RIGHT = 7;

    /**
     * 8为悬停
     */
    public static int WPT_HOVERING = 8;

    /**
     * 16为两点直连的坡度飞行（不以最大垂直速率）
     */
    public static int WPT_OBLIQUE = 16;

    /**
     * 32为预转弯
     */
    public static int WPT_PRETURN = 32;

    /** Landing action */
    public static int WPT_LANDING = 64;

    /** Parachute action */
    public static int WPT_PARACHUTE = 128;
}
