package com.weiran.missionplanning.biz.jna.common;

/**
 * @description：
 * @Author: aoxiaoqin@weiran.com
 * @Date: 2021/7/9 11:03
 **/
public class ActpointType {
    /**
     * do nothing
     */
    public static int APT_NOTHING=0;

    /**
     *  camera instant action
     */
    public static int APT_SNAPING=1;

    /**
     *  camera continuous action
     */
    public static int APT_IMAGING=2;

    /**
     *  pod action for zone scout
     */
    public static int APT_SCOUTING=4;

    /**
     *  lidar action
     */
    public static int APT_SCANNING=8;

    /**
     * trumpet action
     */
    public static int APT_SHOUTING=16;

    /**
     * drop action
     */
    public static int APT_DROPPING=32;

    /**
     *  light action
     */
    public static int APT_LIGHTING=64;

    /**
     * canon action
     */
    public static int APT_SHOOTING=128;
}
