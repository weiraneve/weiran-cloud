package com.weiran.missionplanning.biz.jna.bo;

import lombok.Data;

/**
 * discription:
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/2 14:22
 */
@Data
public class PosDataBO {

    /**
     * 结构体成员定义
     */
    public byte year;       // 0代表2000年 uint8_t
    public byte month;      // 1-12 uint8_t
    public byte day;        // 1-31 uint8_t
    public byte hour;       // UTC时间 uint8_t
    public byte minute;     // uint8_t
    public byte second;     // uint8_t
    public short uavID;        // uint16_t
    public short VersionNum;  //软件版本
    public byte RecordFlag;   //0代表录制，其它未录制
    public byte SDFlag;        // SD卡状态
    public short SDMemory;      // SD卡内存空间

    public int UavLat;     // 飞机纬度 1e7  int32_t
    public int UavLon;     // 飞机经度 1e7  int32_t
    public short HMSL;        // 飞机高度 m   int16_t
    public short VGnd;        // 地速 m/s 1e1  uint16_t
    public short TAS;         // 空速 m/s 1e1  uint16_t
    public short Rev2;        // uint16_t

    public int TGTlat;     // 目标纬度 1e7  int32_t
    public int TGTlon;     // 目标经度 1e7  int32_t
    public short TGTHMSL;     // 目标高度 m   int16_t
    public short SlantR;      // 目标距离 m   uint16_t
    public short TargetVelocity; //目标速度 * 100

    public short UavPitch;   // 飞机俯仰 1e4 单位弧度  int16_t
    public short UavYaw;     // 飞机偏航 1e4 单位弧度  int16_t
    public short UavRoll;    // 飞机滚转 1e4 单位弧度  int16_t
    public short Pan;        // 航向欧拉角 1e4 单位弧度  int16_t
    public short Tilt;       // 俯仰欧拉角 1e4 单位弧度  int16_t
    public short Roll;       // 滚转框架角 1e4 单位弧度  int16_t
    public short FramePan;   // 航向框架角 1e4 单位弧度  int16_t
    public short FrameTilt;  // 俯仰框架角 1e4 单位弧度  int16_t
    public short FrameRoll;  // 滚转框架角 1e4 单位弧度  int16_t

    public short ViewAngle;  // 可见光视场角 1e4 单位弧度  uint16_t

    public ImgGeographicLatLonBO[] ImgGeographicVal = new ImgGeographicLatLonBO[5];//0~4分别表示图像（0，0）、（1920，0）、（1920，1080）、（0，1080）、（960，540）五个像素点对应的经纬度坐标

    public int DetLeftTopX;// 跟踪框左上角X坐标  uint32_t
    public int DetLeftTopY;// 跟踪框左上角Y坐标  uint32_t
    public int DetWidth;   // 跟踪框宽度  uint32_t
    public int DetHeight;  // 跟踪框高度  uint32_t

    public int DetTGTclass; // 目标类型, 0:Car; 1:Truck; 2:Bus; 3:not  int32_t
    public byte TimeZoneNum;    // 时区
}
