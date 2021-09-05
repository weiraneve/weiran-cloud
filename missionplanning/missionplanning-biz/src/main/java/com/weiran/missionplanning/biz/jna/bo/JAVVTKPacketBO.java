package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;

import java.util.Arrays;
import java.util.List;

/**
 * discription:视频裸码帧数据结构，包括相关属性和元数据
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/2 10:08
 */
public class JAVVTKPacketBO extends Structure {

    public JAVVTKPacketBO() {
        super(ALIGN_NONE);
    }

    public JAVVTKPacketBO(Pointer pointer) {
        super(pointer);
    }

    public Pointer origin_packet;                   ///< 内部使用

    public int size;                                  // 数据长度

    public int flags;                          // A combination of AV_PKT_FLAG values

    public long pts;                           // 显示时间戳
    public long dts;                           // 解码时间戳
    public long duration;                      // 当前帧建议的播放时长

    public ByteByReference data;              // // 码流缓冲区

    public byte meta_data_invalid;         ///< 元数据是否有效 1为有效 非1为无效
    public JAVMetaDataBasicBO.ByValue meta_data_basic;   ///< 姿态数据

    public static class ByReference extends JAVVTKPacketBO implements Structure.ByReference {
    }

    public static class ByValue extends JAVVTKPacketBO implements Structure.ByValue {
    }


    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{"origin_packet", "size", "flags",
                "pts", "dts", "duration","data","meta_data_invalid","meta_data_basic"});
    }
}
