package com.weiran.common.constant;

/**
 * discription: 调用sdk时，做缓存是常用key前缀常量
 */
public class MissionSdkConstant {

    /**
     * 登录账户，同步账户信息
     */
    public final static String USER_MISSION = "user_mission:";

    /**
     * 登录账户，同步账户信息
     */
    public final static String ACCOUNT_RESOURCE = "account_resource:";

    /**
     * 登录账户，同步账户信息 避免死循环
     */
    public final static String TERMINATE_THE_CYCLE = "terminate_the_cycle:";


    /*================地理要素类型================*/
    /**
     * 地理要素集合
     */
    public final static String FEATURE_COLLECTION = "FeatureCollection";

    /**
     * 地理要素
     */
    public final static String FEATURE = "Feature";

    /**
     * 点要素Point
     */
    public final static String POINT = "Point";

    /**
     * 多点要素MultiPoint
     */
    public final static String MULTIPOINT = "MultiPoint";

    /**
     * 线要素LineString
     */
    public final static String LINESTRING = "LineString";

    /**
     * 多边形Polygon
     */
    public final static String POLYGON = "Polygon";

    /*================点类型================*/
    /**
     * 载荷平台
     */
    public final static String UAV = "uav";

    /**
     * 人员
     */
    public final static String OPERATOR = "operator";

    /**
     * 站点
     */
    public final static String SITE = "car";

    /**
     * 目标
     */
    public final static String MISSION_TARGET = "missionTarget";

    /**
     * 工单
     */
    public final static String ORDER = "workOrder";

    /**
     *  测区
     */
    public final static String WORKODRER = "workZone";

    /*================动作点类型================*/

    public final static String APT_SNAPING = "立即拍照";

    public final static String APT_IMAGING = "连续拍照";

    public final static String APT_SCOUTING = "吊舱区域搜索";

    public final static String APT_SCANNING = "雷达扫描";

    public final static String APT_DROPPING = "投掷";

    public final static String APT_LIGHTING = "开灯";

    public final static String APT_SHOUTING = "喇叭喊话";

    public final static String APT_SHOOTING = "canon action";
}
