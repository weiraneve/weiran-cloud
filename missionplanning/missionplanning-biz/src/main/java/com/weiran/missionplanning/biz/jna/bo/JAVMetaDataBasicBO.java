package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * discription:元数据数据基础
 *
 * @author wujinzhu@weiran.com
 * @date 2021/6/29 14:22
 */
public class JAVMetaDataBasicBO extends Structure {
    /**
     * 构造函数定义
     */
    public JAVMetaDataBasicBO() {
        super(ALIGN_NONE);
    }

    public JAVMetaDataBasicBO(Pointer pointer) {
        super(pointer);
    }

    public CarrierVehiclePosInfoBO.ByValue CarrierVehiclePosInfo_p;       ///< 无人机POS数据
    public CarrierVehicleStatusInfoBO.ByValue CarrierVehicleStatusInfo_p; ///< 无人机状态数据

    /**
     * @brief 标明载荷类型
     * @details \n
     *	PayloadOptions & 0x01 不等于0代表存在吊舱载荷
     */
    public byte PayloadOptions;

    public GimbalPayloadInfosBO.ByValue GimbalPayloadInfos_p;             ///< 吊舱POS数据

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends JAVMetaDataBasicBO implements Structure.ByReference {
    }

    public static class ByValue extends JAVMetaDataBasicBO implements Structure.ByValue {
    }

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{
                "CarrierVehiclePosInfo_p", "CarrierVehicleStatusInfo_p", "PayloadOptions","GimbalPayloadInfos_p"
        });
    }
}
