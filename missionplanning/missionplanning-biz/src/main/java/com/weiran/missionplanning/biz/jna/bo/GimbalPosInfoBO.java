package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * discription:吊舱POS数据
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/5 18:29
 */
public class GimbalPosInfoBO extends Structure {

    /**
     * 构造函数定义
     */
    public GimbalPosInfoBO() {
        super(ALIGN_NONE);
    }

    public GimbalPosInfoBO(Pointer pointer) {
        super(pointer);
    }

    public short VisualViewAngleHorizontal; ///< 可见光水平视场角，单位弧度，1E4
    public short VisualViewAngleVertical;   ///< 可见光垂直视场角，单位弧度，1E4
    public short InfaredViewAngleHorizontal;///< 红外水平视场角，单位弧度，1E4
    public short InfaredViewAngleVertical;  ///< 红外垂直视场角，单位弧度，1E4

    public short FocalDistance;             ///< 焦距，单位mm

    public short GimbalPan;                  ///< 吊舱航向欧拉角，单位弧度，1E4
    public short GimbalTilt;                 ///< 吊舱俯仰欧拉角，单位弧度，1E4
    public short GimbalRoll;                 ///< 吊舱滚转欧拉角，单位弧度，1E4

    public short FramePan;                   ///< 航向框架角，单位弧度，1E4
    public short FrameTilt;                  ///< 俯仰框架角，单位弧度，1E4
    public short FrameRoll;                  ///< 滚转框架角，单位弧度，1E4

    public int TGTLat;                     ///< 目标纬度，单位度
    public int TGTLon;                     ///< 目标经度，单位度
    public short TGTHMSL;                    ///< 目标高度，单位m
    public short TGTVelocity;               ///< 目标速度，*100，单位m/s
    public short TGTHeading;                 ///< 目标速度方位角，*100，单位弧度
    public short SlantR;                    ///< 目标估距

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends GimbalPosInfoBO implements Structure.ByReference {}
    public static class ByValue extends GimbalPosInfoBO implements Structure.ByValue{}

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{
                "VisualViewAngleHorizontal", "VisualViewAngleVertical", "InfaredViewAngleHorizontal", "InfaredViewAngleVertical",
                "FocalDistance", "GimbalPan", "GimbalTilt", "GimbalRoll","FramePan",
                "FrameTilt", "FrameRoll", "TGTLat", "TGTLon","TGTHMSL",
                "TGTVelocity", "TGTHeading", "SlantR"});
    }
}
