package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * discription:无人机状态数据
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/5 18:34
 */
public class CarrierVehicleStatusInfoBO extends Structure {
    /**
     * 构造函数定义
     */
    public CarrierVehicleStatusInfoBO() {
        super(ALIGN_NONE);
    }

    public CarrierVehicleStatusInfoBO(Pointer pointer) {
        super(pointer);
    }

    public byte[] CarrierVehicleSN = new byte[32];             ///< 无人机飞控序列号，手动设置
    public short CarrierVehicleID;             ///< 无人机唯一ID
    public int CarrierVehicleFirmwareVersion;///< 无人机固件版本，手动设置
    public byte VeclType;           ///< 飞机型号，0:cw007 1:cw10 2:cw15 3:cw20 4:cw25 5:cw30 6:CW100

    public byte Pdop;               ///< 卫星精度
    public byte NumSV;              ///< 卫星颗数

    public byte Orienteering;       ///< RTK状态，RTK状态，0: RTK 1:SINGLE

    public short RPM;               ///< 发动机转速，r/m
    public byte ThrottleCmd;        ///< 油门指令，1E2
    public short MPowerV;           ///< 主电源，单位V
    public short MPowerA;           ///< 动力电源，单位V
    public byte ElecricQuantity;    ///< 电池电量百分比
    public int EnduranceMileage;  ///< 剩余续航里程，单位m

    /**
     * @brief 搜索任务
     * @details \n
     * 0: NO_TASK,         无任务		OFF \n
     * 1: SEARCH_TASK,     搜寻任务		SCH \n
     * 2: TP_OBSERVE_TASK, 临时观察任务	TPO \n
     * 3: CT_OBSERVE_TASK, 持续观察任务	CTO \n
     * 4: TRACK_TASK,      跟踪任务		TRK \n
     * 5: IDLE_TASK,       闲置任务		IDL \n
     */
    public byte ScoutTask;

    /**
     * @brief 自驾状态
     * @details \n
     * GROUND_TEST,                  //0  地面测试  GTST \n
     * APV_PRE_LAUNCH_STATE,	      //1  飞前检查 PLCH \n
     * APV_ATT_ASSIST_STATE,         //2  姿态辅助 ATT \n
     * APV_HOVER_ASSIST_STATE,       //3  悬停辅助 HOR \n
     * APV_LIFT_OFF_STATE,           //4  离地 LIFT \n
     * APV_CLIMB_OUT_STATE,          //5  爬升 CLMB \n
     * APV_ACCELERATE_STATE,         //6  加速 ACCL \n
     * APV_V2L_STATE,                //7  垂转平 V2L \n
     * APV_FLYING_STATE,             //8  飞行  FLY \n
     * APV_LANDING_STATE,            //9  降落 LAND \n
     * APV_DECELERATE_STATE,         //10 减速 DECL \n
     * APV_L2V_STATE,                //11 平转垂 L2V \n
     * APV_FINAL_HOVER_STATE,        //12 末端悬停 FNHR \n
     * APV_FINAL_DESCENT_STATE,      //13 末端下降 FNDC \n
     * APV_FORCED_LANDING_STATE,     //14 迫降 FRLD \n
     * APV_AHRS_FORCED_LANDING_STATE,//15 AHRS迫降  AFRLD \n
     * APV_SEMI_AUTO_ASSIST_STATE,   //16 半自动辅助 SAST \n
     * APV_SEMI_AUTO_V2L_STATE,      //17 半自动垂转平 SV2L \n
     * APV_SEMI_AUTO_L2V_STATE,      //18 半自动平转垂 SL2V \n
     * APV_AUTO_HOVER_STATE,         //19 即时悬停 AHOR \n
     * APV_SELF_DESTRUCTION_STATE,   //20 自毁 DSRC
     */
    public int APModeStates;

    public short TasCmd;            ///< 空速指令，*10
    public short HeightCmd;          ///< 高度指令，单位m

    public short WypNum;             ///< 当前跟踪航路点

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends CarrierVehicleStatusInfoBO implements Structure.ByReference {
    }

    public static class ByValue extends CarrierVehicleStatusInfoBO implements Structure.ByValue {
    }

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{
                "CarrierVehicleSN", "CarrierVehicleID", "CarrierVehicleFirmwareVersion", "VeclType", "Pdop",
                "NumSV", "Orienteering", "RPM", "ThrottleCmd", "MPowerV",
                "MPowerA", "ElecricQuantity", "EnduranceMileage", "ScoutTask", "APModeStates", "TasCmd",
                "HeightCmd", "WypNum"});
    }
}
