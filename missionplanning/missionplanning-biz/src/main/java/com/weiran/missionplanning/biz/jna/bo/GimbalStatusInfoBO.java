package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * discription:吊舱状态数据
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/5 18:30
 */
public class GimbalStatusInfoBO extends Structure {

    /**
     * 构造函数定义
     */
    public GimbalStatusInfoBO() {
        super(ALIGN_NONE);
    }

    public GimbalStatusInfoBO(Pointer pointer) {
        super(pointer);
    }

    public short GMPower;                   ///< 吊舱电源，*50

    /**
     * @brief 吊舱工作模式
     * @details \n
     * 0x00 速率模式
     * ServoCmd0为航向指令，1e4，rad/s \n
     * ServoCmd1为俯仰指令，1e4，rad/s \n
     * \n
     * 0x01 姿态模式，手柄不支持 \n
     * \n
     * 0x02 关伺服（休眠使用） \n
     * \n
     * 0x03 归零位锁定 \n
     * \n
     * 0x04 零位调整，1e4,rad/s \n
     * ServoCmd0为航向零位调整量， \n
     * ServoCmd1为俯仰零位调整量， \n
     * \n
     * 0x05 航向扫描 \n
     * ServoCmd0为航向扫描速率 1e4，rad/s \n
     * \n
     * 0x06 框架角模式 \n
     * ServoCmd0为航向指令，1e4，rad \n
     * ServoCmd1为俯仰指令，1e4，rad \n
     * \n
     * 0x08 低能量控制 \n
     * \n
     * 0x09 球机速率补偿注入(每按下一次发送0.01度/S的补偿速率值) \n
     */
    public byte ServoCmd;

    public short ServoCmd0;                  ///< 吊舱航向指令，1E4，单位rad，rad/s
    public short ServoCmd1;                  ///< 吊舱俯仰指令，1E4，单位rad，rad/s

    public short PixelElement;              ///< 像元大小，单位um

    public byte GimbalDeployCmd;             ///< 吊舱收放 0:收起 1:放下

    /**
     * @brief 黑热或白热
     * @details \n
     * 0:白热 \n
     * 1:黑热 \n
     * 2:伪彩1 \n
     * 3:伪彩2 \n
     * 4:伪彩3 \n
     * 5:伪彩4 \n
     * 6:伪彩5 \n
     */
    public byte W_or_B;

    public byte FovLock;                    ///< 视场角是否锁定

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends GimbalStatusInfoBO implements Structure.ByReference {
    }

    public static class ByValue extends GimbalStatusInfoBO implements Structure.ByValue {
    }

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{
                "GMPower", "ServoCmd", "ServoCmd0", "ServoCmd1", "PixelElement",
                "GimbalDeployCmd", "W_or_B", "FovLock"});
    }
}
