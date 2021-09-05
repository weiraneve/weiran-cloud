package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * discription:无人机POS数据
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/5 18:33
 */
public class CarrierVehiclePosInfoBO extends Structure {

    /**
     * 构造函数定义 ALIGN_NONE
     */
    public CarrierVehiclePosInfoBO() {
        super(ALIGN_NONE);
    }

    public CarrierVehiclePosInfoBO(Pointer pointer) {
        super(pointer);
    }

    public long TimeStamp; ///< 从1970-01-01:00:00:00开始的毫秒数
    public byte TimeZone; ///< 时区


    public short CarrierVehicleHeadingAngle;///< 飞机偏航角，1E4，单位弧度
    public short CarrierVehiclePitchAngle;  ///< 飞机俯仰角，1E4，单位弧度
    public short CarrierVehicleRollAngle;   ///< 飞机滚转角，1E4，单位弧度

    public int CarrierVehicleLat;         ///< 飞机纬度，1E7
    public int CarrierVehicleLon;         ///< 飞机经度，1E7
    public int CarrierVehicleHMSL;        ///< 飞机海拔高度，1E2，单位m

    public int DisFromHome;   ///< 离家距离，单位m
    public short HeadingFromHome;///< 离家方位角，*100，单位弧度

    public short VGnd;          ///< 地速，单位m/s
    public short Tas;           ///< 空速，单位m/s

    public short VNorth;         ///< 地速(北)，1E2，单位m/s
    public short VEast;          ///< 地速(东)，1E2，单位m/s
    public short VDown;          ///< 地速(地)，1E2，单位m/s

    public int FlySeconds;    ///< 飞机飞行时间，单位s

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends CarrierVehiclePosInfoBO implements Structure.ByReference {}
    public static class ByValue extends CarrierVehiclePosInfoBO implements Structure.ByValue{}

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{
                "TimeStamp", "TimeZone", "CarrierVehicleHeadingAngle", "CarrierVehiclePitchAngle",
                "CarrierVehicleRollAngle", "CarrierVehicleLat", "CarrierVehicleLon", "CarrierVehicleHMSL","DisFromHome",
                "HeadingFromHome", "VGnd", "Tas", "VNorth","VEast","VDown","FlySeconds"});
    }
}
