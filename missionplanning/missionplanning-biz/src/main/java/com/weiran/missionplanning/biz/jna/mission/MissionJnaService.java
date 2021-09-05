package com.weiran.missionplanning.biz.jna.mission;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/5/6 0006 15:28
 */
public interface MissionJnaService extends Library {

    /**
     * DLL文件默认路径为项目根目录，若DLL文件存放在项目外，请使用绝对路径
     * J:\系统与应用软件部\0文件传输\0部门内部文件交互\罗彬\dev\JoSDK
     * D:\sdk-dll\JoSDK
     */
    MissionJnaService INSTANCE = (MissionJnaService) Native.load("J:\\系统与应用软件部\\0文件传输\\0部门内部文件交互\\罗彬\\dev\\JoSDK\\JoMission", MissionJnaService.class);

    /* -------------------------------------------------------------------- */
    /*      ImagingModel.h related functions                                */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建成像模型
     *
     * @return ImagingModelH类型，返回创建的成像模型句柄
     */
    Pointer mission_imagingmodel_create();

    /**
     * @brief: 计算指定地面分辨率下的离地的高度
     *
     * @param   hImagingModel 为输入的成像模型
     * @param   dsd           为输入的地面分辨率
     * @return  double类型，返回载荷离地高度，单位米
     */
    double mission_imagingmodel_calculate_distance(Pointer hImagingModel, double dsd);

    /**
     * @brief: 计算指定地面分辨率下的像片在地面宽度
     *
     * @param   hImagingModel 为输入的成像模型
     * @param   dsd           为输入的地面分辨率
     * @return  double类型，返回像片在地面宽度，单位米
     */
    double mission_imagingmodel_calculate_width_overlay(Pointer hImagingModel, double dsd);

    /**
     * @brief: 得到成像模型的焦距
     *
     * @param  hImagingModel 为输入的成像模型句柄
     *
     * @return double类型，返回焦距的值，单位毫米
     */
    double mission_imagingmodel_get_focal_lenth(Pointer hImagingModel);

    /**
     * @brief: 设置成像模型的焦距
     *
     * @param  hImagingModel 为输入的成像模型句柄
     * @param  dfFocalLenth  为输入的焦距值，单位毫米
     */
    void mission_imagingmodel_set_focal_lenth(Pointer hImagingModel, double dfFocalLenth);

    /**
     * @brief: 得到成像模型的CCD物理尺寸的宽度
     *
     * @param  hImagingModel 为输入的成像模型句柄
     *
     * @return double类型，返回CCD物理尺寸的宽度的值，单位毫米
     */
    double mission_imagingmodel_get_frame_size_w(Pointer hImagingModel);

    /**
     * @brief: 设置成像模型的CCD物理尺寸的宽度
     *
     * @param  hImagingModel 为输入的成像模型句柄
     * @param  dfframeSizeW  为输入的CCD物理尺寸的宽度值，单位毫米
     */
    void mission_imagingmodel_set_frame_size_w(Pointer hImagingModel, double dfframeSizeW);

    /**
     * @brief: 得到成像模型的CCD物理尺寸的高度
     *
     * @param  hImagingModel 为输入的成像模型句柄
     *
     * @return double类型，返回CCD物理尺寸的高度的值，单位毫米
     */
    double mission_imagingmodel_get_frame_size_h(Pointer hImagingModel);

    /**
     * @brief: 设置成像模型的CCD物理尺寸的高度
     *
     * @param  hImagingModel 为输入的成像模型句柄
     * @param  dfFrameSizeH  为输入的CCD物理尺寸的高度值，单位毫米
     */
    void mission_imagingmodel_set_frame_size_h(Pointer hImagingModel, double dfFrameSizeH);

    /**
     * @brief: 得到成像模型的像片大小宽度
     *
     * @param  hImagingModel 为输入的成像模型句柄
     *
     * @return double类型，返回像片大小宽度的值，单位毫米
     */
    double mission_imagingmodel_get_pix_mapsize_w(Pointer hImagingModel);

    /**
     * @brief: 设置成像模型的像片大小宽度
     *
     * @param  hImagingModel 为输入的成像模型句柄
     * @param  dfPixmapSizeW 为输入的像片大小宽度值，单位毫米
     */
    void mission_imagingmodel_set_pix_mapsize_w(Pointer hImagingModel, double dfPixmapSizeW);

    /**
     * @brief: 得到成像模型的像片大小高度
     *
     * @param  hImagingModel 为输入的成像模型句柄
     *
     * @return double类型，返回像片大小高度的值，单位毫米
     */
    double mission_imagingmodel_get_pix_mapsize_h(Pointer hImagingModel);

    /**
     * @brief: 设置成像模型的像片大小高度
     *
     * @param  hImagingModel 为输入的成像模型句柄
     * @param  dfPixmapSizeH 为输入的像片大小高度值，单位毫米
     */
    void mission_imagingmodel_set_pix_mapsize_h(Pointer hImagingModel, double dfPixmapSizeH);

    /* -------------------------------------------------------------------- */
    /*      CarrierModel.h related functions                                */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建载体模型
     *
     * @return CarrierModelH类型，返回创建的载体模型句柄
     */
    Pointer mission_carriermodel_create();

    /**
     * @brief: 判断载体模型的参数是否有效
     *
     * @param  hCarrierModel 为输入的载体模型句柄
     *
     * @return bool类型，返回载体参数是否有效，true有效，false无效
     */
    boolean mission_carriermodel_is_valid(Pointer hCarrierModel);

    /**
     * @brief: 得到载体模型的转弯半径
     *
     * @param  hCarrierModel 为输入的载体模型句柄
     *
     * @return double类型，返回转弯半径的值，单位米
     */
    double mission_carriermodel_get_orbit_radius(Pointer hCarrierModel);

    /**
     * @brief: 设置载体模型的转弯半径
     *
     * @param  hCarrierModel 为输入的载体模型句柄
     * @param  radius        为输入的转弯半径值，单位米
     */
    void mission_carriermodel_set_orbit_radius(Pointer hCarrierModel, double radius);

    /**
     * @brief: 得到载体模型的最大向下坡度角
     *
     * @param  hCarrierModel 为输入的载体模型句柄
     *
     * @return double类型，返回最大向下坡度角的值，单位度
     */
    double mission_carriermodel_get_max_drop_angle(Pointer hCarrierModel);

    /**
     * @brief: 设置载体模型的最大向下坡度角
     *
     * @param  hCarrierModel 为输入的载体模型句柄
     * @param  angle         为输入的最大向下坡度角的值，单位度
     */
    void mission_carriermodel_set_max_drop_angle(Pointer hCarrierModel, double angle);

    /**
     * @brief: 得到载体模型的最大向上坡度角
     *
     * @param  hCarrierModel 为输入的载体模型句柄
     *
     * @return double类型，返回最大向上坡度角的值，单位度
     */
    double mission_carriermodel_get_max_climb_angle(Pointer hCarrierModel);

    /**
     * @brief: 设置载体模型的最大向上坡度角
     *
     * @param  hCarrierModel 为输入的载体模型句柄
     * @param  angle        为输入的最大向上坡度角的值，单位度
     */
    void mission_carriermodel_set_max_climb_angle(Pointer hCarrierModel, double angle);

    /* -------------------------------------------------------------------- */
    /*      payloadModel .h related functions                               */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建载荷模型
     *
     * @return PayloadModelH类型，返回创建的载荷模型句柄
     */
    Pointer mission_payloadmodel_create();

    /**
     * @brief: 判断载荷模型的参数是否有效
     *
     * @param  hPayloadModel 为输入的载荷模型句柄
     *
     * @return bool类型，返回载荷参数是否有效，true有效，false无效
     */
    boolean mission_payloadmodel_is_valid(Pointer hPayloadModel);

    /**
     * @brief: 得到载荷模型中的成像模型列表
     *
     * @param  hPayloadModel 为输入的载荷模型句柄
     * @param  imagingModels 为输出的成像模型列表指针首地址
     * @param  count         为输出的成像模型列表个数
     */
    void mission_payloadmodel_get_imagingmodel(Pointer hPayloadModel, PointerByReference imagingModels, IntByReference count);

    /**
     * @brief: 设置载荷模型中的成像模型列表
     *
     * @param  hPayloadModel 为输入的载荷模型句柄
     * @param  imagingModels 为输入的成像模型列表指针首地址
     * @param  count         为输入的成像模型列表个数
     */
    void mission_payloadmodel_set_imagingmodel(Pointer hPayloadModel, PointerByReference imagingModels, int count);

    /* -------------------------------------------------------------------- */
    /*      Actpoint.h related functions                                    */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建动作点类
     *
     * @return ActpointH类型，返回创建的动作点句柄
     */
    Pointer mission_actpoint_create();

    /**
     * @brief: 创建动作点类
     *
     * @param   x            为该三维点的纬度
     * @param   y            为该三维点的经度
     * @param   z            为该三维点的高度
     * @param   m            为该三维点的时间戳
     * @param   Roll         为相片对地的外方位元素滚转角，单位弧度
     * @param   Pitch        为相片对地的外方位元素俯仰角，单位弧度
     * @param   Heading      为相片对地的外方位元素偏航角，单位弧度
     * @param   eMat         为动作点的类型枚举值，（1）-1代表什么都不做，
     *（2）0代表相机拍照，（3）1代表吊舱进行区域搜索，（4）2代表雷达扫描，（5）4代表喇叭喊话
     * @param   nFreq        为动作频率值：当actpointType为相机拍照时，1就是开始拍照，0就是结束拍照；
     *
     * @return  ActpointH类型，返回创建的动作点句柄
     */
    Pointer mission_actpoint_create_la(double x, double y, double z, double m,
                                       double Roll, double Pitch, double Heading,
                                       int eMat, int nFreq);

    /**
     * @brief: 创建动作点类
     *
     * @param   hFeature 为输入生成该动作点的父类
     *
     * @return  ActpointH类型，返回创建的任务点句柄
     */
    Pointer mission_actpoint_create_feature(Pointer hFeature);

    /**
     * @brief: 得到该点纬度
     *
     * @param   hActpoint 为输入的动作点句柄
     *
     * @return  double类型，返回该点纬度
     */
    double mission_actpoint_get_latitude(Pointer hActpoint);

    /**
     * @brief: 设置该点纬度
     *
     * @param   hActpoint 为输入的动作点句柄
     * @param   Lat       为输入的该点的纬度
     *
     */
    void mission_actpoint_set_latitude(Pointer hActpoint, double Lat);

    /**
     * @brief: 得到该点经度
     *
     * @param   hActpoint 为输入的动作点句柄
     *
     * @return  double类型，返回该点经度
     */
    double mission_actpoint_get_longitude(Pointer hActpoint);

    /**
     * @brief: 设置该点经度
     *
     * @param   hActpoint 为输入的动作点句柄
     * @param   Lon       为输入的该点的经度
     *
     */
    void mission_actpoint_set_longitude(Pointer hActpoint, double Lon);

    /**
     * @brief: 得到该点高度
     *
     * @param   hActpoint 为输入的动作点句柄
     *
     * @return  double类型，返回该点高度
     */
    double mission_actpoint_get_altitude(Pointer hActpoint);

    /**
     * @brief: 设置该点高度
     *
     * @param   hActpoint 为输入的动作点句柄
     * @param   Alt       为输入的该点的高度
     *
     */
    void mission_actpoint_set_altitude(Pointer hActpoint, double Alt);

    /**
     * @brief: 得到该点发生的时间戳
     *
     * @param   hActpoint 为输入的动作点句柄
     *
     * @return  double类型，返回该点发生的时间戳
     */
    double mission_actpoint_get_time_stamp(Pointer hActpoint);

    /**
     * @brief: 设置该点发生的时间戳
     *
     * @param   hActpoint 为输入的动作点句柄
     * @param   Ts        为输入的该点发生的时间戳
     *
     */
    void mission_actpoint_set_time_stamp(Pointer hActpoint, double Ts);

    /**
     * @brief: 得到该点三维坐标
     *
     * @param   hActpoint 为输入的动作点句柄
     * @param   *x        为输出该任务点的维度
     * @param   *y        为输出该任务点的经度
     * @param   *z        为输出该任务点的高度
     * @param   *m        为输出该任务点的时间戳
     *
     * @return  double类型，返回该点三维坐标
     */
    void mission_actpoint_get_position(Pointer hActpoint, DoubleByReference x, DoubleByReference y, DoubleByReference z, DoubleByReference m);

    /**
     * @brief: 设置该点三维坐标
     *
     * @param   hActpoint 为输入的动作点句柄
     * @param   x         为输入该任务点的纬度
     * @param   y         为输入该任务点的经度
     * @param   z         为输入该任务点的高度
     * @param   m         为输入该任务点的时间戳
     */
    void mission_actpoint_set_position(Pointer hActpoint, double x, double y, double z, double m);

    /**
     * @brief: 得到该任务点的姿态角
     *
     * @param   hActpoint 为输入的动作点句柄
     * @param   *Roll     为输出相片对地的外方位元素的滚转角
     * @param   *Pitch    为输出相片对地的外方位元素的俯仰角
     * @param   *Heading  为输出相片对地的外方位元素的偏航角
     */
    void mission_actpoint_get_posture(Pointer hActpoint, DoubleByReference Roll, DoubleByReference Pitch, DoubleByReference Heading);

    /**
     * @brief: 设置任务点的姿态角
     *
     * @param   hActpoint 为输入的动作点句柄
     * @param   Roll      为输入该相片对地的外方位元素的滚转角
     * @param   Pitch     为输入该相片对地的外方位元素的俯仰角
     * @param   Heading   为输入该相片对地的外方位元素的偏航角
     *
     */
    void mission_actpoint_set_posture(Pointer hActpoint, double Roll, double Pitch, double Heading);

    /**
     * @brief: 得到该任务点的频率
     *
     * @param   hActpoint 为输入的动作点句柄
     *
     * @return  int类型，返回该动作频率值：当actpointType为相机拍照时，1就是开始拍照，0就是结束拍照；
     */
    int mission_actpoint_get_frequency(Pointer hActpoint);

    /**
     * @brief: 设置该任务点的频率
     *
     * @param   hActpoint 为输入的动作点句柄
     * @param   nFreq     为输入的该动作频率值：当actpointType为相机拍照时，1就是开始拍照，0就是结束拍照；
     *
     */
    void mission_actpoint_set_frequency(Pointer hActpoint, int nFreq);

    /**
     * @brief: 得到该任务点类型枚举值
     *
     * @param   hActpoint 为输入的动作点句柄
     *
     * @return  ActpointType类型，返回该任务点类型
     */
    int mission_actpoint_get_type(Pointer hActpoint);

    /**
     * @brief: 设置该任务点类型
     *
     * @param   hActpoint 为输入的动作点句柄
     * @param   eApp      为输入的该任务点类型
     *
     */
    void mission_actpoint_set_type(Pointer hActpoint, int eApp);

    /* -------------------------------------------------------------------- */
    /*      Waypoint.h related functions                                    */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建航点类
     *
     * @return WaypointH类型，返回创建的航点句柄
     */
    Pointer mission_waypoint_create();

    /**
     * @brief: 创建航点类
     *
     * @param   dfLat         为输入的该三维点的纬度
     * @param   dfLon         为输入的该三维点的经度
     * @param   dfAlt         为输入的该三维点的高度
     * @param   dfTimeStamp   为输入的该三维点的时间戳
     * @param   dfOrbitRadius 为输入的载体的盘旋半径，单位米
     * @param   nOrbitTime    为输入的载体转弯时间，单位s
     *
     * @return  WaypointH类型，返回创建的航点句柄
     */
    Pointer mission_waypoint_create_la_ti(double dfLat, double dfLon, double dfAlt,
                                          double dfTimeStamp, double dfOrbitRadius, int nOrbitTime);

    /**
     * @brief: 创建航点类
     *
     * @param   dfLat 为输入的该三维点的纬度
     * @param   dfLon 为输入的该三维点的经度
     * @param   dfAlt 为输入的该三维点的高度
     *
     * @return  WaypointH类型，返回创建的航点句柄
     */
    Pointer mission_waypoint_create_la(double dfLat, double dfLon, double dfAlt);

    /**
     * @brief: 创建航点类
     *
     * @param   hFeature 为输入的该航点的父类，要素
     *
     * @return  WaypointH类型，返回创建的航点句柄
     */
    Pointer mission_waypoint_create_feature(Pointer hFeature);

    /**
     * @brief: 得到该点纬度
     *
     * @param   hWaypoint 为输入的航点句柄
     *
     * @return  double类型，返回该点纬度
     */
    double mission_waypoint_get_latitude(Pointer hWaypoint);

    /**
     * @brief: 设置该航点的纬度
     *
     * @param   hWaypoint 为输入的航点句柄
     * @param   lat       为输入的该航点的纬度
     *
     */
    void mission_waypoint_set_latitude(Pointer hWaypoint, double lat);

    /**
     * @brief: 得到该点经度
     *
     * @param   hWaypoint 为输入的航点句柄
     *
     * @return  double类型，返回该点经度
     */
    double mission_waypoint_get_longitude(Pointer hWaypoint);

    /**
     * @brief: 设置该航点的经度
     *
     * @param   hWaypoint 为输入的航点句柄
     * @param   lon       为输入的该航点的经度
     *
     */
    void mission_waypoint_set_longitude(Pointer hWaypoint, double lon);

    /**
     * @brief: 得到该点高度
     *
     * @param   hWaypoint 为输入的航点句柄
     *
     * @return  double类型，返回该点高度
     */
    double mission_waypoint_get_altitude(Pointer hWaypoint);

    /**
     * @brief: 设置该航点的高度
     *
     * @param   hWaypoint 为输入的航点句柄
     * @param   alt       为输入的该航点的高度
     *
     */
    void mission_waypoint_set_altitude(Pointer hWaypoint, double alt);

    /**
     * @brief: 得到该航点的时间戳
     *
     * @param   hWaypoint 为输入的航点句柄
     *
     * @return  double类型，返回该航点的时间戳
     */
    double mission_waypoint_get_time_stamp(Pointer hWaypoint);

    /**
     * @brief: 设置该航点的时间戳
     *
     * @param   hWaypoint 为输入的航点句柄
     * @param   ts        为输入的该航点的时间戳
     *
     */
    void mission_waypoint_set_time_stamp(Pointer hWaypoint, double ts);

    /**
     * @brief: 得到该航点的四维坐标
     *
     * @param   hWaypoint 为输入的航点句柄
     * @param   *x        为输出该航点的纬度
     * @param   *y        为输出该航点的经度
     * @param   *z        为输出该航点的高度
     * @param   *m        为输出该航点的时间戳
     */
    void mission_waypoint_get_position(Pointer hWaypoint, DoubleByReference x, DoubleByReference y, DoubleByReference z, DoubleByReference m);

    /**
     * @brief: 设置该航点的纬度
     *
     * @param   hWaypoint 为输入的航点句柄
     * @param   x         为输入该航点的纬度
     * @param   y         为输入该航点的经度
     * @param   z         为输入该航点的高度
     * @param   m         为输入该航点的时间戳
     *
     */
    void mission_waypoint_set_position(Pointer hWaypoint, double x, double y, double z, double m);

    /**
     * @brief: 得到该航点盘旋半径
     *
     * @param   hWaypoint 为输入的航点句柄
     *
     * @return  double类型，返回该航点盘旋半径
     */
    double mission_waypoint_get_orbit_radius(Pointer hWaypoint);

    /**
     * @brief: 设置该航点盘旋半径
     *
     * @param   hWaypoint 为输入的航点句柄
     * @param   dfOr      为输入的该航点盘旋半径
     *
     */
    void mission_waypoint_set_orbit_radius(Pointer hWaypoint, double dfOr);

    /**
     * @brief: 得到该航点盘旋时间
     *
     * @param   hWaypoint 为输入的航点句柄
     *
     * @return  int类型，返回该航点盘旋时间，单位秒
     */
    int mission_waypoint_get_orbit_time(Pointer hWaypoint);

    /**
     * @brief: 设置该航点盘旋时间
     *
     * @param   hWaypoint 为输入的航点句柄
     * @param   dfOt      为输入的该航点盘旋时间
     *
     */
    void mission_waypoint_set_orbit_time(Pointer hWaypoint, double dfOt);

    /**
     * @brief: 得到该时刻的空速
     *
     * @param   hWaypoint 为输入的航点句柄
     *
     * @return  double类型，返回该时刻的空速
     */
    double mission_waypoint_get_air_speed(Pointer hWaypoint);

    /**
     * @brief: 设置该时刻的空速
     *
     * @param   hWaypoint 为输入的航点句柄
     * @param   dfAs      为输入的该时刻的空速
     *
     */
    void mission_waypoint_set_air_speed(Pointer hWaypoint, double dfAs);

    /**
     * @brief: 得到该航点的属性
     *
     * @param   hWaypoint 为输入的航点句柄
     *
     * @return  WaypointType类型，返回该航点的属性
     * waypointType：航路点类型，值：（1）-1为常规类型；（2）0为逆时针绕点盘旋（该航路点为中心点）；
     *（3）1为顺时针绕点盘旋（该航路点为中心点）；（4）2为逆时针过点盘旋（该航路点为切点）；
     *（5）3为顺时针过点盘旋（该航路点为切点）；（6）4为逆时针过高盘旋；（7）5为顺时针过高盘旋；
     *（8）6为逆时针过低盘旋；（9）7为顺时针过低盘旋；（10）8为悬停；
     *（11）16为两点直连的坡度飞行（不以最大垂直速率）；（12）32为预转弯。
     */
    int mission_waypoint_get_type(Pointer hWaypoint);

    /**
     * @brief: 设置该航点的属性
     *
     * @param   hWaypoint 为输入的航点句柄
     * @param   eWpp      为输入的该航点的属性
     * waypointType：航路点类型，值：（1）-1为常规类型；（2）0为逆时针绕点盘旋（该航路点为中心点）；
     *（3）1为顺时针绕点盘旋（该航路点为中心点）；（4）2为逆时针过点盘旋（该航路点为切点）；
     *（5）3为顺时针过点盘旋（该航路点为切点）；（6）4为逆时针过高盘旋；（7）5为顺时针过高盘旋；
     *（8）6为逆时针过低盘旋；（9）7为顺时针过低盘旋；（10）8为悬停；
     *（11）16为两点直连的坡度飞行（不以最大垂直速率）；（12）32为预转弯。
     */
    void mission_waypoint_set_type(Pointer hWaypoint, int eWpp);

    /* -------------------------------------------------------------------- */
    /*      zone.h related functions                                        */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建测区类
     *
     * @return ZoneH类型，返回创建的测区句柄
     */
    Pointer mission_zone_create();

    /**
     * @brief: 创建测区类
     *
     * @param   hFeature 为输入测区的要素
     *
     * @return  ZoneH类型，返回创建的测区句柄
     */
    Pointer mission_zone_create_feature(Pointer hFeature);

    /**
     * @brief: 得到测区的名称
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  const char*类型，返回测区的名称字符串
     */
    String mission_zone_get_name(Pointer hZone);

    /**
     * @brief: 设置该测区的名称
     *
     * @param   hZone  为输入的测区句柄
     * @param   dfName 为输入的该测区的名称
     *
     */
    void mission_zone_set_name(Pointer hZone, String dfName);

    /**
     * @brief: 得到测区的类型
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  ZoneType类型，返回测区的类型，值为点、线、面
     */
    int mission_zone_get_Type(Pointer hZone);

    /**
     * @brief: 设置该测区的类型
     *
     * @param   hZone     为输入的测区句柄
     * @param   eZoneType 为输入的该测区的类型，值为点、线、面
     *
     */
    void mission_zone_set_type(Pointer hZone, int eZoneType);

    /**
     * @brief: 得到测区的参数之一航向重叠度
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  double类型，返回测区的航向重叠度，百分值
     */
    double mission_zone_get_course_overlap_ratio(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一航向重叠度
     *
     * @param   hZone                为输入的测区句柄
     * @param   dfCourseOverlapRatio 为输入的该测区的参数之一航向重叠度，百分值
     *
     */
    void mission_zone_set_course_overlap_ratio(Pointer hZone, double dfCourseOverlapRatio);

    /**
     * @brief: 得到测区的参数之一旁向重叠度
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  double类型，返回测区的参数之一旁向重叠度，百分值
     */
    double mission_zone_get_lateral_overlap_ratio(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一旁向重叠度
     *
     * @param   hZone                 为输入的测区句柄
     * @param   dfLateralOverlapRatio 为输入的该测区的参数之一旁向重叠度，百分值
     *
     */
    void mission_zone_set_lateral_overlap_ratio(Pointer hZone, double dfLateralOverlapRatio);

    /**
     * @brief:  得到测区的参数之一外扩距离
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  double类型，返回测区的参数之一外扩距离，单位米
     */
    double mission_zone_get_buffer_distance(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一外扩距离
     *
     * @param   hZone            为输入的测区句柄
     * @param   dlBufferDistance 为输入的该测区的参数之一外扩距离，单位米
     *
     */
    void mission_zone_set_buffer_distance(Pointer hZone, double dlBufferDistance);

    /**
     * @brief: 得到测区的参数之一地面基准高度
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  double类型，返回测区的参数之一地面基准高度，单位米
     */
    double mission_zone_get_datum_plane_height(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一地面基准高度
     *
     * @param   hZone            为输入的测区句柄
     * @param   datumPlaneHeight 为输入的该测区的参数之一地面基准高度，单位米
     *
     */
    void mission_zone_set_datum_plane_height(Pointer hZone, double datumPlaneHeight);

    /**
     * @brief: 得到测区的参数之一顶点
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  int类型，返回测区的参数之一顶点，测区多边形A、B、C、D选择的顶点值
     */
    int mission_zone_get_cur_entry_point(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一顶点
     *
     * @param   hZone         为输入的测区句柄
     * @param   curEntryPoint 为输入的参数之一顶点值，测区多边形A、B、C、D选择的顶点值
     *
     */
    void mission_zone_set_cur_entry_point(Pointer hZone, int curEntryPoint);

    /**
     * @brief: 得到测区的参数之一是否要仿地飞行
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  bool类型，返回测区的参数之一是否要仿地飞行
     */
    boolean mission_zone_get_adaptive_altitude(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一是否要仿地飞行
     *
     * @param   hZone              为输入的测区句柄
     * @param   dfadaptiveAltitude 为输入的该测区的参数之一是否要仿地飞行
     *
     */
    void mission_zone_set_adaptive_altitude(Pointer hZone, boolean dfadaptiveAltitude);

    /**
     * @brief: 得到测区的参数之一单条航线的里程
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  double类型，返回测区的参数之一单条航线的里程，单位米
     */
    double mission_zone_get_ground_sample_distance(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一目标分辨率
     *
     * @param   hZone                  为输入的测区句柄
     * @param   dfgroundSampleDistance 为输入的该测区的参数之一单条航线的里程，单位米
     *
     */
    void mission_zone_set_ground_sample_distance(Pointer hZone, double dfgroundSampleDistance);

    /**
     * @brief: 得到测区的参数之一是否有架构航线
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  bool类型，返回测区的参数之一是否有架构航线
     */
    boolean mission_zone_get_framework_enable(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一是否有架构航线
     *
     * @param   hZone           为输入的测区句柄
     * @param   frameworkEnable 为输入的该测区的参数之一是否有架构航线
     *
     */
    void mission_zone_set_framework_enable(Pointer hZone, boolean frameworkEnable);

    /**
     * @brief: 得到测区的参数之一架构航线是否优先
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  bool类型，返回测区的参数之一架构航线是否优先
     */
    boolean mission_zone_get_framework_prior(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一架构航线是否优先
     *
     * @param   hZone          为输入的测区句柄
     * @param   frameworkPrior 为输入的该测区的参数之一架构航线是否优先
     *
     */
    void mission_zone_set_framework_prior(Pointer hZone, boolean frameworkPrior);

    /**
     * @brief: 得到测区的参数之一架构倍数
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  int类型，返回测区的参数之一架构倍数
     */
    int mission_zone_get_framework_ends_count(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一架构倍数
     *
     * @param   hZone              为输入的测区句柄
     * @param   frameworkEndsCount 为输入的该测区的参数之一架构倍数
     *
     */
    void mission_zone_set_framework_ends_count(Pointer hZone, int frameworkEndsCount);

    /**
     * @brief: 得到测区的参数之一架构对数
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  int类型，返回测区的参数之一架构对数
     */
    int mission_zone_get_framework_pair_count(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一架构对数
     *
     * @param   hZone              为输入的测区句柄
     * @param   frameworkPairCount 为输入的该测区的参数之一架构对数
     *
     */
    void mission_zone_set_framework_pair_count(Pointer hZone, int frameworkPairCount);

    /**
     * @brief: 得到测区的参数之一架构高差
     *
     * @param   hZone 为输入的测区句柄
     *
     * @return  double类型，返回测区的参数之一架构高差
     */
    double mission_zone_get_framework_raised_height(Pointer hZone);

    /**
     * @brief: 设置该测区的参数之一架构高差
     *
     * @param   hZone                 为输入的测区句柄
     * @param   frameworkRaisedHeight 为输入的该测区的参数之一架构高差，单位米
     *
     */
    void mission_zone_set_framework_raised_height(Pointer hZone, double frameworkRaisedHeight);

    double mission_zone_get_master_course_angle(Pointer hZone);

    void mission_zone_set_master_course_angle(Pointer hZone, double master_course_angle);

    /* -------------------------------------------------------------------- */
    /*      unit.h related functions                                        */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建单元类
     *
     * @return UnitH类型，返回创建的单元句柄
     */
    Pointer mission_unit_create(Pointer hfeature);

    /**
     * @brief:  得到单元的类型枚举值
     *
     * @param   hUnit 为输入的单元句柄
     *
     * @return  int类型，返回单元的类型枚举值
     */
    int mission_unit_get_class_type(Pointer hUnit);

    /* -------------------------------------------------------------------- */
    /*      Player.h related functions                                      */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建任务装备类
     *
     * @return PlayerH类型，返回创建的任务装备句柄
     */
    Pointer mission_player_create();

    /**
     * @brief: 创建执行任务装备类类
     *
     * @param   playerName 为输入的任务装备的名称
     *
     * @return  PlayerH类型，返回创建的任务装备句柄
     */
    Pointer mission_player_create_name(String playerName);

    /**
     * @brief: 创建任务设备类
     *
     * @param   hPlayer 为输入的任务装备类其他句柄
     *
     * @return  PlayerH类型，返回创建的任务装备句柄
     */
    Pointer mission_player_create_player(Pointer hPlayer);

    /**
     * @brief: 得到执行任务的载体模型
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  CarrierModelH类型，返回执行任务的载体模型
     */
    Pointer mission_player_get_carriermodel(Pointer hPlayer);

    /**
     * @brief: 设置执行任务的载体模型
     *
     * @param   hPlayer       为输入的任务装备句柄
     * @param   hCarrierModel 为输入执行任务的载体模型
     *
     */
    void mission_player_set_carriermodel(Pointer hPlayer, Pointer hCarrierModel);

    /**
     * @brief: 得到执行任务的载荷模型
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  PayloadModelH类型，返回执行任务的载荷模型
     */
    Pointer mission_player_get_payloadmodel(Pointer hPlayer);

    /**
     * @brief: 设置执行任务的载荷模型
     *
     * @param   hPayloadModel       为输入的任务装备句柄
     * @param   hPayloadModel 为输入执行任务的载荷模型
     *
     */
    void mission_player_set_payloadmodel(Pointer hPayloadModel, PointerByReference imagingModels, int count);

    /**
     * @brief: 得到执行任务的成像模型
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  ImagingModelH类型，返回执行任务的成像模型
     */
    Pointer mission_player_get_imagingmodel(Pointer hPlayer);

    /**
     * @brief: 设置执行任务的成像模型
     *
     * @param   hPlayer       为输入的任务装备句柄
     * @param   hImagingModel 为输入执行任务的成像模型
     *
     */
    void mission_player_set_imagingmodel(Pointer hPlayer, Pointer hImagingModel);

    /**
     * @brief: 得到任务设备的标签
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  const char*类型，返回执行任务设备的标签
     */
    String mission_player_get_label(Pointer hPlayer);

    /**
     * @brief: 设置执行任务设备的标签
     *
     * @param   hPlayer  为输入的任务装备句柄
     * @param   setlaber 为输入执行任务设备的标签字符串
     *
     */
    void mission_player_set_label(Pointer hPlayer, String setlaber);

    /**
     * @brief: 得到执行任务设备的描述
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  const char*类型，返回执行任务设备的描述字符串
     */
    String mission_player_get_information(Pointer hPlayer);

    /**
     * @brief: 设置执行任务设备的描述
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   info    为输入执行任务设备的描述
     *
     */
    void mission_player_set_information(Pointer hPlayer, String info);

    /**
     * @brief: 得到执行任务设备当前对地外方位元素中姿态的偏航角
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  double类型，返回执行任务设备当前对地外方位元素中姿态的偏航角，单位弧度
     */
    double mission_player_get_heading(Pointer hPlayer);

    /**
     * @brief: 设置当前执行任务设备对地外方位元素中姿态的偏航角
     *
     * @param   hPlayer   为输入的任务装备句柄
     * @param   dfHeading 为输入当前执行任务设备对地外方位元素中姿态的偏航角，单位弧度
     *
     */
    void mission_player_set_heading(Pointer hPlayer, double dfHeading);

    /**
     * @brief: 得到当前执行任务设备对地外方位元素中姿态的俯仰角
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  double类型，返回当前执行任务设备对地外方位元素中姿态的俯仰角，单位弧度
     */
    double mission_player_get_picth(Pointer hPlayer);

    /**
     * @brief: 设置当前执行任务设备对地外方位元素中姿态的俯仰角
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   dfPitch 为输入当前执行任务设备对地外方位元素中姿态的俯仰角
     *
     */
    void mission_player_set_picth(Pointer hPlayer, double dfPitch);

    /**
     * @brief: 得到当前执行任务设备对地外方位元素中姿态的滚转角
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  double类型，返回当前执行任务设备对地外方位元素中姿态的滚转角
     */
    double mission_player_get_roll(Pointer hPlayer);

    /**
     * @brief: 设置当前执行任务设备对地外方位元素中姿态的滚转角
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   dfRoll  为输入当前执行任务设备对地外方位元素中姿态的滚转角
     *
     */
    void mission_player_set_roll(Pointer hPlayer, double dfRoll);

    /**
     * @brief: 得到当前执行任务设备的对地外方位元素中姿态
     *
     * @param   hPlayer   为输入的任务装备句柄
     * @param   dfHeading 为输出的对地外方位元素中姿态中偏航角
     * @param   dfPitch   为输出的对地外方位元素中姿态中俯仰角
     * @param   dfRoll    为输出的对地外方位元素中姿态中滚转角
     *
     */
    void mission_player_get_euler_angle(Pointer hPlayer, DoubleByReference dfHeading,
                                        DoubleByReference dfPitch,
                                        DoubleByReference dfRoll);

    /**
     * @brief: 设置当前执行任务设备的对地外方位元素中姿态
     *
     * @param   hPlayer   为输入的任务装备句柄
     * @param   dfHeading 为输入的对地外方位元素中姿态中偏航角
     * @param   dfPitch   为输入的对地外方位元素中姿态中俯仰角
     * @param   dfRoll    为输入的对地外方位元素中姿态中滚转角
     *
     */
    void mission_player_set_euler_angle(Pointer hPlayer, double dfHeading, double dfPitch, double dfRoll);

    /**
     * @brief: 得到当前执行任务设备的对地外方位元素中姿态，用四元素表示
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   a       为输出的对地外方位元素中姿态用四元素表示系数1
     * @param   b       为输出的对地外方位元素中姿态用四元素表示系数2
     * @param   c       为输出的对地外方位元素中姿态用四元素表示系数3
     * @param   d       为输出的对地外方位元素中姿态用四元素表示系数4
     */
    void mission_player_get_quaternion(Pointer hPlayer, DoubleByReference a, DoubleByReference b, DoubleByReference c, DoubleByReference d);

    /**
     * @brief: 设置当前执行任务设备的对地外方位元素中姿态，用四元素表示
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   a       为输入的对地外方位元素中姿态用四元素表示系数1
     * @param   b       为输入的对地外方位元素中姿态用四元素表示系数2
     * @param   c       为输入的对地外方位元素中姿态用四元素表示系数3
     * @param   d       为输入的对地外方位元素中姿态用四元素表示系数4
     *
     */
    void mission_player_set_quaternion(Pointer hPlayer, double a, double b, double c, double d);

    /**
     * @brief: 得到当前执行任务设备的对地外方位元素中三维位置中纬度
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  double类型，返回当前执行任务设备的对地外方位元素中三维位置中纬度
     */
    double mission_player_get_latitudel(Pointer hPlayer);

    /**
     * @brief: 设置当前执行任务设备的对地外方位元素中三维位置中纬度
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   dfLat   为输入当前执行任务设备的对地外方位元素中三维位置中纬度
     *
     */
    void mission_player_set_latitudel(Pointer hPlayer, double dfLat);

    /**
     * @brief: 得到当前执行任务设备的对地外方位元素中三维位置中经度
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  double类型，返回当前执行任务设备的对地外方位元素中三维位置中经度
     */
    double mission_player_get_longitude(Pointer hPlayer);

    /**
     * @brief: 设置当前执行任务设备的对地外方位元素中三维位置中经度
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   dfLon   为输入当前执行任务设备的对地外方位元素中三维位置中经度
     *
     */
    void mission_player_set_longitude(Pointer hPlayer, double dfLon);

    /**
     * @brief: 得到当前执行任务设备的对地外方位元素中三维位置中高度
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  double类型，返回当前执行任务设备的对地外方位元素中三维位置中高度
     */
    double mission_player_get_altitude(Pointer hPlayer);

    /**
     * @brief: 设置当前执行任务设备的对地外方位元素中三维位置中高度
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   dfAlt   为输入当前执行任务设备的对地外方位元素中三维位置中高度
     *
     */
    void mission_player_set_altitude(Pointer hPlayer, double dfAlt);

    /**
     * @brief: 得到当前执行任务设备的时间戳
     *
     * @param   hPlayer 为输入的任务装备句柄
     *
     * @return  double类型，返回当前执行任务设备的时间戳
     */
    double mission_player_get_time_stamp(Pointer hPlayer);

    /**
     * @brief: 设置当前执行任务设备的时间戳
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   dfTs    为输入当前执行任务设备的时间戳
     *
     */
    void mission_player_set_time_stamp(Pointer hPlayer, double dfTs);

    /**
     * @brief: 得到当前执行任务设备的对地外方位元素中三维位置
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   dfLat   为输出的对地外方位元素三维位置中纬度
     * @param   dfLon  为输出的对地外方位元素三维位置中经度
     * @param   dfAlt   为输出的对地外方位元素三维位置中高度
     * @param   dfTs    为输出的对地外方位元素三维位置中时间戳
     */
    void mission_player_get_position(Pointer hPlayer, DoubleByReference dfLat,
                                     DoubleByReference dfLon,
                                     DoubleByReference dfAlt,
                                     DoubleByReference dfTs);

    /**
     * @brief: 设置当前执行任务设备的对地外方位元素中三维位置
     *
     * @param   hPlayer 为输入的任务装备句柄
     * @param   dfLat   为输入的对地外方位元素三维位置中纬度
     * @param   dfLon  为输入的对地外方位元素三维位置中经度
     * @param   dfAlt   为输入的对地外方位元素三维位置中高度
     * @param   dfTs    为输入的对地外方位元素三维位置中时间戳
     *
     */
    void mission_player_set_position(Pointer hPlayer, double dfLat, double dfLon, double dfAlt, double dfTs);

    /* -------------------------------------------------------------------- */
    /*      Target.h related functions                                      */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建任务目标类
     *
     * @return TargetH类型，返回创建的任务目标句柄
     */
    Pointer mission_target_create(int geometryType, String targetName);

    /**
     * @brief: 通过json字符串创建目标类
     *
     * @param  json  为输入目标的json字符串
     *
     * @return TargetH类型，返回创建目标句柄
     */
    Pointer mission_target_create_from_json(String json);

    /**
     * @brief: 得到任务目标的名称
     *
     * @param   hTarget 为输入的任务目标句柄
     *
     * @return  const char*类型，返回任务目标的名称字符串
     */
    String mission_target_get_name(Pointer hTarget);

    /**
     * @brief: 设置任务目标的名称
     *
     * @param    hTarget 为输入的任务目标句柄
     * @param    dfName  为输入任务目标的名称字符串
     */
    void mission_target_set_name(Pointer hTarget, String dfName);

    /**
     * @brief: 得到表示任务目标的点坐标列表
     *
     * @param   hTarget 为输入的任务目标句柄
     * @param   x       为输出表示任务目标的点坐标列表中的纬度指针首地址
     * @param   y       为输出表示任务目标的点坐标列表中的经度指针首地址
     * @param   z       为输出表示任务目标的点坐标列表中的高度指针首地址
     * @param   m       为输出表示任务目标的点坐标列表中的时间戳指针首地址
     * @param   count   为输出表示任务目标的点坐标列表的个数
     */
    void mission_target_get_points(Pointer hTarget,
                                   DoubleByReference x, DoubleByReference y, DoubleByReference z, DoubleByReference m, IntByReference count);
    /**
     * @brief: 设置表示任务目标的点坐标列表
     *
     * @param   hTarget  为输入的任务目标句柄
     * @param   x        为输入表示任务目标的点坐标列表中的纬度指针首地址
     * @param   y        为输入表示任务目标的点坐标列表中的经度指针首地址
     * @param   z        为输入表示任务目标的点坐标列表中的高度指针首地址
     * @param   m        为输入表示任务目标的点坐标列表中的时间戳指针首地址
     * @param   count    为输入表示任务目标的点坐标列表的个数
     */
    void mission_target_set_points(Pointer hTarget,
                                   double[] x, double[] y, double[] z, double[] m, int count);
    /**
     * @brief: 得到表示任务目标的点坐标列表中指定序号的坐标点
     *
     * @param   hTarget 为输入的任务目标句柄
     * @param   index   为输出表示任务目标的点坐标列表中指定序号
     * @param   x       为输出表示任务目标的点坐标列表中指定序号坐标的纬度
     * @param   y       为输出表示任务目标的点坐标列表中指定序号坐标的经度
     * @param   z       为输出表示任务目标的点坐标列表中指定序号坐标的高度
     * @param   m       为输出表示任务目标的点坐标列表中指定序号坐标的时间戳
     */
    void mission_target_get_point(Pointer hTarget,int index,
                                  DoubleByReference x, DoubleByReference y, DoubleByReference z, DoubleByReference m);
    /**
     * @brief: 设置表示任务目标的几何体坐标
     *
     * @param    hTarget 为输入的任务目标句柄
     * @param    x       为输入表示任务目标的点坐标纬度
     * @param    y       为输入表示任务目标的点坐标经度
     * @param    z       为输入表示任务目标的点坐标高度
     * @param    m       为输入表示任务目标的点坐标时间戳
     */
    void mission_target_set_point(Pointer hTarget, double x, double y, double z, double m);

    /**
     * @brief: 得到任务目标区域内平均高程
     *
     * @param   hTarget 为输入的任务目标句柄
     *
     * @return  double类型，返回任务目标区域内平均高程，单位米
     */
    double mission_target_get_average_altitude(Pointer hTarget);

    /**
     * @brief: 得到任务目标区域内最高高程
     *
     * @param   hTarget 为输入的任务目标句柄
     *
     * @return  double类型，返回任务目标区域内最高高程，单位米
     */
    double mission_target_get_highest_altitude(Pointer hTarget);

    /* -------------------------------------------------------------------- */
    /*      plan.h related functions                                        */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建计划类
     *
     * @return PlanH类型，返回创建的计划句柄
     */
    Pointer mission_plan_create();

    /**
     * @brief: 创建计划类
     * @param  planName 为输入的计划的名称字符串
     *
     * @return PlanH类型，返回创建的计划句柄
     */
    Pointer mission_plan_create_name(String planName);

    /**
     * @brief: 得到计划中目标列表
     *
     * @param   hPlan      为输入的计划句柄
     * @param   targetList 为输出的计划中目标列表指针首地址
     * @param   count      为输出的计划中目标列表个数
     */
    void mission_plan_get_targets(Pointer hPlan, PointerByReference targetList, IntByReference count);

    /**
     * @brief: 设置目标列表到计划类中
     *
     * @param   hPlan      为输入的计划句柄
     * @param   targetList 为输入的计划中目标列表指针首地址
     * @param   count      为输入的计划中目标列表个数
     */
    void mission_plan_set_targets(Pointer hPlan, PointerByReference targetList, int count);

    /**
     * @brief: 得到计划中测区列表
     *
     * @param   hPlan     为输入的计划句柄
     * @param   zoneList  为输出的计划中测区列表指针首地址
     * @param   count     为输出的计划中测区列表个数
     */
    void mission_plan_get_zones(Pointer hPlan, Pointer[] zoneList, IntByReference count);

    /**
     * @brief: 设置测区列表到计划类中
     *
     * @param   hPlan     为输入的计划句柄
     * @param   zoneList  为输入的计划中测区列表指针首地址
     * @param   count     为输入的计划中测区列表个数
     */
    void mission_plan_set_zones(Pointer hPlan, PointerByReference zoneList, int count);

    /**
     * @brief: 得到计划中动作点列表
     *
     * @param   hPlan         为输入的计划句柄
     * @param   actpointList  为输出的计划中动作点列表指针首地址
     * @param   count         为输出的计划中动作点列表个数
     */
    void mission_plan_get_action(Pointer hPlan, Pointer[] actpointList, IntByReference count);

    /**
     *  @brief: 得到计划中动作点列表个数
     * @param hPlan  为输入的计划句柄
     * @return
     */
    int mission_plan_get__action_count(Pointer hPlan);

    /**
     *  @brief: 获取当前动作点
     * @param hPlan
     * @param index
     * @return
     */
    Pointer mission_plan_get_action_at(Pointer hPlan,int index);
    /**
     * @brief: 设置动作点列表到计划类中
     *
     * @param   hPlan         为输入的计划句柄
     * @param   actpointList 为输入的计划中动作点列表指针首地址
     * @param   count         为输入的计划中动作点列表个数
     */
    void mission_plan_set_action(Pointer hPlan, Pointer[] actpointList, int count);

    /**
     * @brief: 得到计划中航点列表
     *
     * @param   hPlan       为输入的计划句柄
     * @param   waypoinList 为输出的计划中航点列表指针首地址
     * @param   count       为输出的计划中航点列表个数
     */
    void mission_plan_get_route(Pointer hPlan, Pointer[] waypoinList, IntByReference count);

    /**
     * @brief: 设置航点列表到计划类中
     *
     * @param   hPlan       为输入的计划句柄
     * @param   waypoinList 为输入的计划中航点列表指针首地址
     * @param   count       为输入的计划中航点列表个数
     */
    void mission_plan_set_route(Pointer hPlan, Pointer[] waypoinList, int count);

    /**
     * @brief: 得到当前任务计划是否选中
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  int类型，返回是否选中当前任务计划
     */
    int mission_plan_get_selected_index(Pointer hPlan);

    /**
     * @brief: 设置当前任务计划是否选中
     *
     * @param   hPlan  为输入的计划句柄
     * @param   index  为输入选择的任务计划序号
     */
    void mission_plan_set_selected_index(Pointer hPlan, int index);

    /**
     * @brief: 得到任务计划的home点
     *
     * @param   hPlan 为输入的计划句柄
     * @param   x     为输出home的纬度
     * @param   y     为输出home的经度
     * @param   z     为输出home的高度
     * @param   m     为输出home的时间戳
     */
    void mission_plan_get_home(Pointer hPlan, DoubleByReference x, DoubleByReference y, DoubleByReference z, DoubleByReference m);

    /**
     * @brief: 设置任务计划的home点
     *
     * @param   hPlan 为输入的计划句柄
     * @param   x     为输入home的纬度
     * @param   y     为输入home的经度
     * @param   z     为输入home的高度
     * @param   m     为输入home的时间戳
     */
    void mission_plan_set_home(Pointer hPlan, double x, double y, double z, double m);

    /**
     * @brief: 得到当前任务计划开始执行时间
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  tm类型，返回当前任务计划开始执行时间
     */
    Pointer mission_plan_get_start_time(Pointer hPlan);

    /**
     * @brief: 设置当前任务计划开始执行时间
     *
     * @param   hPlan    为输入的计划句柄
     * @param   datatime 为输入当前任务计划开始执行时间
     */
    void mission_plan_set_start_time(Pointer hPlan, Pointer datatime);

    /**
     * @brief: 得到当前任务计划执行时间开始到结束
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  tm类型，返回当前任务计划执行时间开始到结束
     */
    Pointer mission_plan_get_working_time(Pointer hPlan);

    /**
     * @brief: 得到当前任务计划作业总里程
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  double类型，返回当前任务计划作业总里程
     */
    double mission_plan_get_working_course(Pointer hPlan);

    /**
     * @brief: 得到当前任务计划作业面积
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  double类型，返回当前任务计划作业面积
     */
    double mission_plan_get_working_area(Pointer hPlan);

    /**
     * @brief: 得到当前任务计划中航点的最低海拔高度
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  double类型，返回当前任务计划中航点的最低海拔高度
     */
    double mission_plan_get_route_bottom(Pointer hPlan);

    /**
     * @brief: 得到当前任务计划中航点的最高海拔高度
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  double类型，返回当前任务计划中航点的最高海拔高度
     */
    double mission_plan_get_highest_altitude(Pointer hPlan);

    /**
     * @brief: 得到当前任务计划中航点的平均海拔高度
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  double类型，返回当前任务计划中航点的平均海拔高度
     */
    double mission_plan_get_average_altitude(Pointer hPlan);

    /**
     * @brief: 得到当前任务计划中航点的个数
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  int类型，返回当前任务计划中航点的个数
     */
    int mission_plan_get_route_count(Pointer hPlan);

    /**
     *  得到当前路径点
     * @param hPlan
     * @param index
     * @return
     */
    Pointer mission_plan_get_route_at(Pointer hPlan, int index);
    /**
     * @brief: 得到当前任务计划中任务设备类
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  PlayerH类型，返回当前任务计划中任务设备句柄
     */
    Pointer mission_plan_get_player(Pointer hPlan);

    /**
     * @brief: 设置当前任务计划中任务设备类
     *
     * @param   hPlan  为输入的计划句柄
     * @param   player 为输入当前任务计划中任务设备句柄
     */
    void mission_plan_set_player(Pointer hPlan, Pointer player);

    /**
     * @brief: 任务计划生成JSON字符串流
     *
     * @param   hPlan 为输入的计划句柄
     *
     * @return  const char*类型，返回当前任务计划生成JSON字符串流
     */
    String mission_plan_to_json(Pointer hPlan);

    /* -------------------------------------------------------------------- */
    /*      Order.h related functions                                       */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建工单类
     *
     * @param  orderName 为输入工单的名称
     *
     * @return OrderH类型，返回创建工单句柄
     */
    Pointer mission_order_create(String orderName);

    /**
     * @brief: 通过json字符串创建工单类
     *
     * @param  json  为输入工单的json字符串
     *
     * @return OrderH类型，返回创建工单句柄
     */
    Pointer mission_order_parse_from_json(String json);

    /**
     * @brief: 得到工单中选择的单元列表
     *
     * @param   hOrder   为输入的工单句柄
     * @param   unitList 为输出的工单中选择的单元列表指针首地址
     * @param   count    为输出的工单中选择的单元列表个数
     */
    void mission_order_get_selected_units(Pointer hOrder, PointerByReference unitList, IntByReference count);

    /**
     * @brief: 选择单元列表到工单中
     *
     * @param   hOrder   为输入的工单句柄
     * @param   unitList 为输出的工单中选择的单元列表指针首地址
     * @param   count    为输出的工单中选择的单元列表个数
     */
    void mission_order_select(Pointer hOrder, PointerByReference unitList, int count);

    /**
     * @brief: 某些单元列表在工单中不选择（移除）
     *
     * @param   hOrder   为输入的工单句柄
     * @param   unitList 为输出的工单中不选择的单元列表指针首地址
     * @param   count    为输出的工单中不选择的单元列表个数
     */
    void mission_order_unselect(Pointer hOrder, PointerByReference unitList, int count);

    /**
     * @brief: 得到工单中任务计划列表
     *
     * @param   hOrder   为输入的工单句柄
     * @param   planList 为输出的工单中任务计划列表指针首地址
     * @param   count    为输出的工单中任务计划列表的个数
     */
    void mission_order_get_plans(Pointer hOrder, Pointer[] planList, IntByReference count);

    /**
     * @brief: 得到工单中指定序号的任务计划
     *
     * @param  hOrder   为输入的工单句柄
     * @param  index    为输入指定任务计划的序号
     *
     * @return PlanH类型，返回工单中指定序号的任务计划句柄
     */
    Pointer mission_order_get_plan(Pointer hOrder, int index);

    /**
     * @brief: 设置任务计划到工单中
     *
     * @param   hOrder  为输入的工单句柄
     * @param   plan    为输入的任务计划句柄
     */
    void mission_order_set_plan(Pointer hOrder, Pointer plan);

    /**
     * @brief: 得到工单中任务计划列表的总数
     *
     * @param  hOrder  为输入的工单句柄
     *
     * @return int类型，返回工单中任务计划列表的总数
     */
    int mission_order_get_plan_count(Pointer hOrder);

    /**
     * @brief: 在工单中移除指定序号的任务列表
     *
     * @param  hOrder  为输入的工单句柄
     * @param  index   为输入指定任务计划的序号
     *
     * @return bool类型，返回工单中指定序号的任务计划移除是否成功
     */
    boolean mission_order_remove_plan(Pointer hOrder, int index);

    /**
     * @brief: 得到工单作业时间
     *
     * @param   hOrder  为输入的工单句柄
     *
     * @return  tm类型，返回工单作业时间，开始到结束
     */
    Pointer mission_order_get_all_time(Pointer hOrder);

    /**
     * @brief: 设置工单作业时间
     *
     * @param   hOrder    为输入的工单句柄
     * @param   dataTime  为输入工单作业时间，开始到结束
     */
    void mission_order_set_all_time(Pointer hOrder, Pointer dataTime);

    /**
     * @brief: 得到工单对于站点的标签
     *
     * @param   hOrder  为输入的工单句柄
     *
     * @return  const char*类型，返回工单对于站点的标签字符串
     */
    String mission_order_get_station_label(Pointer hOrder);

    /**
     * @brief: 设置工单对于站点的标签
     *
     * @param   hOrder       为输入的工单句柄
     *
     * @param   stationLabel 为输入工单对于站点的标签字符串
     */
    void mission_order_set_station_label(Pointer hOrder, String stationLabel);

    /**
     * @brief: 得到工单作业总里程
     *
     * @param   hOrder  为输入的工单句柄
     *
     * @return  double类型，返回工单作业总里程
     */
    double mission_order_get_all_odometers(Pointer hOrder);

    /**
     * @brief: 得到工单总作业面积
     *
     * @param   hOrder  为输入的工单句柄
     *
     * @return  double类型，返回工单总作业面积
     */
    double mission_order_get_all_areas(Pointer hOrder);

    /* -------------------------------------------------------------------- */
    /*      project.h related functions                                     */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 创建工程类
     *
     * @return ProjectH类型，返回为创建工程句柄
     */
    Pointer mission_project_create(String projectName, String location, Pointer datetime);

    /**
     * @brief: 根据json字符串流创建工程类
     *
     * @param   json 为输入的json字符串流
     *
     * @return  ProjectH类型，返回为创建工程句柄
     */
    Pointer mission_project_parse_from_json(String json);

    /**
     * @brief: 得到工程中选择的单元列表
     *
     * @param   hProject 为输入的工程句柄
     * @param   unitList 为输出的工程中选择的单元列表指针首地址
     * @param   count    为输出的工程中选择的单元列表个数
     */
    void mission_project_get_selected_units(Pointer hProject, PointerByReference unitList, IntByReference count);

    /**
     * @brief:  获取当前工程中所有的公共资源池中的资源个数
     * @param   hProject 为输入的当前工程句柄
     * @return  int 类型，返回当前工程中所有的公共资源池中的资源个数
     */
    int mission_project_get_selected_units_count(Pointer hProject);

    /**
     * @brief:  从当前工程根据索引获取资源（人员、站点、运载工具）
     *
     * @param   hProject 为输入的当前工程句柄
     * @param   Index	 索引号
     *
     * @return  UnitH 类型，返回当前工程根据索引获取资源
     */

    Pointer mission_project_get_selected_unit_at(Pointer hProject, int Index);

    /**
     * @brief: 某些单元列表选择到工程中
     *
     * @param   hProject 为输入的工程句柄
     * @param   unitList 为输入的单元列表的首地址
     * @param   count    为输入的单元列表的个数
     */
    void mission_project_select(Pointer hProject, PointerByReference unitList, int count);

    /**
     * @brief: 某些单元列表不选择到工程中（移除）
     *
     * @param   hProject 为输入的工程句柄
     * @param   unitList 为输入的单元列表的首地址
     * @param   count    为输入的单元列表的个数
     */
    void mission_project_unselect(Pointer hProject, PointerByReference unitList, int count);

    /**
     * @brief: 得到工程中工单列表
     *
     * @param   hProject  为输入的工程句柄
     * @param   orderList 为输出的工单列表的首地址
     * @param   count     为输入的工单列表的个数
     */
    void mission_project_get_orders(Pointer hProject, Pointer[] orderList, IntByReference count);

    /**
     * @brief: 得到工程中指定序号的工单
     *
     * @param   hProject 为输入的工程句柄
     * @param   index    为输入的指定工单序号
     *
     * @return  OrderH类型，返回指定序号的工单句柄
     */
    Pointer mission_project_get_order_index(Pointer hProject,int index);

    /**
     * @brief: 得到工程中工单列表的总数
     *
     * @param   hProject 为输入的工程句柄
     *
     * @return  int类型，返回工程中工单列表的总数
     */
    int mission_project_get_order_count(Pointer hProject);

    /**
     * @brief: 设置工单到工程中
     *
     * @param   hProject 为输入的工程句柄
     * @param   order    为输入的工单
     */
    boolean mission_project_set_order(Pointer hProject, Pointer order);

    /**
     * @brief: 工程中删除指定序号的工单
     *
     * @param   hProject 为输入的工程句柄
     * @param   index    为输入的指定序号
     *
     * @return  bool类型，返回是否删除成功
     */
    boolean mission_project_remove_order(Pointer hProject, int index);

    void mission_unit_get_position(Pointer hUnit, DoubleByReference dfLat,
                                   DoubleByReference dfLon,
                                   DoubleByReference dfAlt,
                                   DoubleByReference dfTs);

    void mission_project_set_select_order_index(Pointer hProject, int index);

    int mission_project_get_select_order_index(Pointer hProject);

    int mission_order_get_selected_units_count(Pointer hOrder);

    Pointer mission_order_get_selected_unit_at(Pointer hOrder, int Index);

    /**
     * 通过工单获取设备列表
     * @param hOrder
     * @param unitList
     * @param count
     */
    void mission_order_get_selected_units(Pointer hOrder, Pointer[] unitList, IntByReference count);

    double mission_target_get_length(Pointer hTarget);

    double mission_target_get_area(Pointer hTarget);

    String mission_unit_get_JSON(Pointer hUnit);

    /**
     * 获取计划名称
     * @param hPlan
     * @return
     */
    String mission_plan_get_name(Pointer hPlan);

    int mission_plan_get_zones_count(Pointer hPlan);

    /**
     *
     * @param hUnit
     * @return
     */
    String mission_unit_get_id(Pointer hUnit);

    String mission_plan_get_vehicle_id(Pointer hPlan);

    /**
     * 获取测区-焦距
     * @param hZone
     * @return
     */
    double mission_zone_get_focal(Pointer hZone);

    /**
     * 编辑测区-焦距
     * @param hZone
     * @param focal
     */
    void mission_zone_set_focal(Pointer hZone, double focal);

    /**
     * -1：未编辑测区 0：完成 其他：生成中
     * @param hPlan
     * @return
     */
    int mission_plan_get_state(Pointer hPlan);

    /**
     *  路径点最低
     * @param hPlan
     * @return
     */
    double mission_plan_get_lowest_altitude(Pointer hPlan);

    /**
     * 获取工单状态
     * ORDER_UNKNOWN = -1
     * ORDER_EDITING = 0
     * ORDER_EXECUTING = 1
     * ORDER_OVER = 2
     * @param hOrder
     * @return
     */
    int mission_order_get_state(Pointer hOrder);

    /**
     * 获取工单名称
     * @param hOrder
     * @return
     */
    String mission_order_get_name(Pointer hOrder);
}
