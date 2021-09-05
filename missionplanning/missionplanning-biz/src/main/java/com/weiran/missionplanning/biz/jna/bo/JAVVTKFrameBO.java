package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;

import java.util.Arrays;
import java.util.List;

/**
 * discription:视频图像数据结构，包含相关属性和元数据
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/2 10:11
 */
public class JAVVTKFrameBO extends Structure {

    public JAVVTKFrameBO() {
        super(ALIGN_NONE);
    }

    public JAVVTKFrameBO(Pointer pointer) {
        super(pointer);
    }

    public Pointer origin_frame;
    public ByteByReference data;                          // 解码后的图像数据（格式为BGR24）
    public int width;                             // 图像宽
    public int height;                            // 图像高
    public float time_point;                      // 当前帧时间点，从0开始，单位为秒

    public byte meta_data_invalid;         ///< 元数据是否有效 1为有效 非1为无效
    public JAVMetaDataBasicBO.ByValue meta_data_basic;   ///< 姿态数据

    public static class ByReference extends JAVVTKFrameBO implements Structure.ByReference {}
    public static class ByValue extends JAVVTKFrameBO implements Structure.ByValue{}

    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{
                "origin_frame", "data", "width", "height", "time_point", "meta_data_invalid","meta_data_basic"
        });
    }
}
