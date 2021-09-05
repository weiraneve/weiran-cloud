package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * discription:视频图像顶点及中心点坐标
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/5 18:32
 */
public class ImageVertexCoordinateBO extends Structure {
    /**
     * 构造函数定义
     */
    public ImageVertexCoordinateBO() {
        super(ALIGN_NONE);
    }

    public ImageVertexCoordinateBO(Pointer pointer) {
        super(pointer);
    }

    public int Lat;   ///< 纬度 1E7
    public int Lon;   ///< 经度 1E7
    public int HMSL;  ///< 高度，单位m

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends ImageVertexCoordinateBO implements Structure.ByReference {}
    public static class ByValue extends ImageVertexCoordinateBO implements Structure.ByValue{}

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{"Lat", "Lon", "HMSL"});
    }
}
