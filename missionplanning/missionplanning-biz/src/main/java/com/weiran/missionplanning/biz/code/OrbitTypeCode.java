package com.weiran.missionplanning.biz.code;

/**
 * @description： 盘旋方式
 * @Author: aoxiaoqin@weiran.com
 * @Date: 2021/7/13 19:45
 **/
public enum OrbitTypeCode {

    WPT_ORBIT_TANGENT("过点盘旋",1),

    WPT_ORBIT("绕点盘旋",2),

    ORBIT_LEFT("左盘旋",3),

    ORBIT_RIGHT("右盘旋",4),

    ORBIT_ABOVE("过高盘旋",5),

    ORBIT_BELOW("过低盘旋",6);


    // 成员变量
    private String name;
    private int code;

    private OrbitTypeCode(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
