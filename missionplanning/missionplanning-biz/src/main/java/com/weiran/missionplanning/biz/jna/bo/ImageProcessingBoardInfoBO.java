package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * discription:图像处理板数据
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/5 18:31
 */
public class ImageProcessingBoardInfoBO  extends Structure {

    /**
     * 构造函数定义
     */
    public ImageProcessingBoardInfoBO() {
        super(ALIGN_NONE);
    }

    public ImageProcessingBoardInfoBO(Pointer pointer) {
        super(pointer);
    }

//    public int Version;                   ///< 图像处理程序版本号

    public short SearchWidth;               ///< 搜索框宽度
    public short SearchHeight;              ///< 搜索框高度

    public short ServoCrossX;               ///< 随动中心X坐标
    public short ServoCrossY;               ///< 随动中心Y坐标
    public short ServoCrossWidth;           ///< 随动十字宽度
    public short ServoCrossHeight;          ///< 随动十字高度

    public short TrackLeftTopX;             ///< 跟踪框左上角X坐标
    public short TrackLeftTopY;             ///< 跟踪框左上角Y坐标
    public short TrackWidth;                ///< 跟踪框宽度
    public short TrackHeight;               ///< 跟踪框高度

    public ImageVertexCoordinateBO[] ImgCood = new ImageVertexCoordinateBO[5];   ///< 视频图像5个点的坐标

    public short SDMemory;                  ///< SD卡剩余内存，*10，单位G
    public short SnapNum;                   ///< 快照数

    /**
     * @brief SD卡状态
     * @details \n
     *	0:SD卡正常； \n
     *	1:无mmcblk1设备； \n
     *	2:mmcblk1设备挂载成功，但删除文件失败，SD卡内存空间小于200M; \n
     *	3:mmcblk1设备挂载成功，但删除文件失败，SD卡内存空间大于200M，小于8G; \n
     *	4:有mmcblk1设备，但是未挂载成功
     */
    public byte SDFlag;

    /**
     * @brief 录制状态
     * @details \n
     *	0:未录制； \n
     *	1:录制； \n
     *	2:未录制；
     */
    public byte RecordFlag;

    /**
     * @brief 跟踪类型
     * @details \n
     *	0:红外跟踪 \n
     *	1:可见光跟踪 \n
     *	2:非跟踪态
     */
    public byte TrackFlag;

    /**
     * @brief 车辆跟踪 \n
     * @details \n
     *	0:关闭 \n
     *	1:开启
     */
    public byte AI_R;

    /**
     * @brief 车辆跟踪状态
     * @details \n
     *	1:车辆跟踪 \n
     *	0:非车辆跟踪
     */
    public byte CarTrack;

    /**
     * @brief 跟踪类别
     * @details \n
    0:Car ; \n
    1:Truck; \n
    2:Bus; \n
    3:not
     */
    public byte TrackClass;

    /**
     * @brief 跟踪状态
     * @details \n
    0x00:非车辆锁定  \n
    0x01:脱锁，进入速率半自主 \n
    0x02:跟踪状态不佳，但仍是跟踪态，仅关闭RTT \n
    0x03:车辆锁定
     */
    public byte TrackStatus;

    public int Version;                   ///< 图像处理程序版本号

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends ImageProcessingBoardInfoBO implements Structure.ByReference {}
    public static class ByValue extends ImageProcessingBoardInfoBO implements Structure.ByValue{}

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{
                "SearchWidth", "SearchHeight", "ServoCrossX","ServoCrossY",
                "ServoCrossWidth", "ServoCrossHeight", "TrackLeftTopX", "TrackLeftTopY","TrackWidth",
                "TrackHeight", "ImgCood", "SDMemory", "SnapNum","SDFlag",
                "RecordFlag", "TrackFlag", "AI_R", "CarTrack","TrackClass","TrackStatus","Version"});
    }
}
