package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/5/6 0006 17:26
 */
public class TimeBO extends Structure {

    /**
     * 构造函数定义
     */
    public TimeBO() {
        super();
    }

    public TimeBO(Pointer pointer) {
        super(pointer);
    }

    public int tm_sec;
    public int tm_min;
    public int tm_hour;
    public int tm_mday;
    public int tm_mon;
    public int tm_year;
    public int tm_wday;
    public int tm_yday;
    public int tm_isdst;

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends TimeBO implements Structure.ByReference {}
    public static class ByValue extends TimeBO implements Structure.ByValue{}

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{"tm_sec", "tm_min", "tm_hour", "tm_mday", "tm_mon", "tm_year", "tm_wday", "tm_yday", "tm_isdst"});
    }

}
