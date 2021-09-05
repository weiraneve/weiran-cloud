package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/3/12 0012 10:56
 */
public class ImgGeographicLatLonBO extends Structure {

    /**
     * 构造函数定义
     */
    public ImgGeographicLatLonBO() {
        super();
    }

    public ImgGeographicLatLonBO(Pointer pointer) {
        super(pointer);
    }

    public int lat;//纬度 int32_t
    public int lon;//经度 int32_t
    public short tgthmsl;//高度 uint16_t
    public short res1;//保留 uint16_t

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends ImgGeographicLatLonBO implements Structure.ByReference {}
    public static class ByValue extends ImgGeographicLatLonBO implements Structure.ByValue{}

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{"lat", "lon", "tgthmsl", "res1"});
    }
}
