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
public class CurveParmetersBO extends Structure {

    /**
     * 构造函数定义
     */
    public CurveParmetersBO() {
        super();
    }

    public CurveParmetersBO(Pointer pointer) {
        super(pointer);
    }

    public Double R;
    public Double cx;
    public Double cy;
    public Double alpha0;
    public Double alpha1;
    public Double alpha2;

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends CurveParmetersBO implements Structure.ByReference {}
    public static class ByValue extends CurveParmetersBO implements Structure.ByValue{}

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{"R", "cx", "cy", "alpha0", "alpha1", "alpha2"});
    }
}
