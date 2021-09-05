package com.weiran.missionplanning.biz.jna.domian;

import com.weiran.missionplanning.biz.jna.bo.TimeBO;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.awt.*;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/5/6 0006 15:28
 */
public interface DoMainJnaService extends Library {

    /**
     * DLL文件默认路径为项目根目录，若DLL文件存放在项目外，请使用绝对路径
     * J:\系统与应用软件部\0文件传输\0部门内部文件交互\罗彬\dev\JoSDK
     * D:\sdk-dll\JoSDK
     */
    DoMainJnaService INSTANCE = (DoMainJnaService) Native.load("J:\\系统与应用软件部\\0文件传输\\0部门内部文件交互\\罗彬\\dev\\JoSDK\\JoDomain", DoMainJnaService.class);


    /* -------------------------------------------------------------------- */
    /*      product.h related functions                                     */
    /* -------------------------------------------------------------------- */

    Boolean domain_component_is_registered(Pointer hComponent);

    /**
     * 获取各对象id
     * @param hComponent
     * @return
     */
    String domain_component_get_id(Pointer hComponent);

    /**
     * 获取个对象类型
     * @param hComponent
     * @return
     */
    String domain_component_get_model(Pointer hComponent);

    String domain_component_get_version(Pointer hComponent);

    String domain_component_get_datetime(Pointer hComponent);

    String domain_component_get_description(Pointer hComponent);

    String domain_component_get_organization(Pointer hComponent);

    String domain_component_get_activation_key(Pointer hComponent);

    int domain_component_get_product_category(Pointer hComponent);

    double domain_product_get_price(Pointer hProduct);

    Boolean domain_product_get_is_activated(Pointer hProduct);

    Boolean domain_product_activate(Pointer hProduct, String pszActivationKey);

    /**
     * 获取对象名称
     * @param hProduct
     * @return
     */
    String domain_product_get_nickname(Pointer hProduct);

    void domain_product_set_nickname(Pointer hProduct, String pszNickname);

    int domain_product_get_component_count(Pointer hProduct);

    Pointer domain_product_get_components(Pointer hProduct);

    Pointer domain_product_get_component_at(Pointer hProduct, int nIndex);

    int domain_product_append_component(Pointer hProduct, Pointer hComponent);

    Boolean domain_product_replace_component(Pointer hProduct, int nIndex, Pointer hComponent);

    Boolean domain_product_remove_component(Pointer hProduct, int nIndex);

    /* -------------------------------------------------------------------- */
    /*      operator.h related functions                                    */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 判断操作员对产品的飞检是否成功
     *
     * @param  hOperator 为输入的操作员指针
     * @param  hProduct  为输入的产品指针
     *
     * @return char类型，输出表示飞检是否成功
     */
    String domain_operator_check_up(Pointer hOperator, Pointer hProduct);

    /* -------------------------------------------------------------------- */
    /*      payload.h related functions                                     */
    /* -------------------------------------------------------------------- */

    int domain_payload_get_position(Pointer hPayload,
                                    DoubleByReference dfLat,
                                    DoubleByReference dfLon,
                                    DoubleByReference dfAlt);

    int domain_payload_get_installation(Pointer hPayload,
                                        DoubleByReference pdfXOffset,
                                        DoubleByReference pdfYOffset,
                                        DoubleByReference pdfZOffset,
                                        DoubleByReference pdfXRotation,
                                        DoubleByReference pdfYRotation,
                                        DoubleByReference pdfZRotation);

    Pointer domain_payload_get_sensors(Pointer hPayload);

    Pointer domain_sensor_get_geoshape(Pointer hSensor);

    int domain_sensor_get_pixel_size(Pointer hSensor, IntByReference pnWidth, IntByReference pnHeight);

    int domain_sensor_get_frame_size(Pointer hSensor, DoubleByReference pdfWidth, DoubleByReference pdfHeight);

    int domain_sensor_get_view_angles(Pointer hSensor, DoubleByReference pdfVAOV, DoubleByReference pdfHAOV);

    /* -------------------------------------------------------------------- */
    /*      Vehicle.h related functions                                     */
    /* -------------------------------------------------------------------- */

    int domain_vehicle_get_pilot_count(Pointer hVehicle);

    Pointer domain_vehicle_get_pilots(Pointer hVehicle);

    Pointer domain_vehicle_get_pilot_at(Pointer hVehicle, int nIndex);

    Pointer domain_vehicle_get_controller(Pointer hVehicle);

    void domain_vehicle_select_payload(Pointer hVehicle,int nIndex);

    void domain_controller_launch(Pointer hController, String pszKey, Callback pfnCallback);

    void domain_controller_setout(Pointer hController, String pszKey, Callback pfnCallback);

    void domain_controller_gohome(Pointer hController, String pszKey, Callback pfnCallback);

    void domain_controller_cutoff(Pointer hController, String pszKey, Callback pfnCallback);

    /* -------------------------------------------------------------------- */
    /*      station.h related functions                                     */
    /* -------------------------------------------------------------------- */

    int domain_station_get_pilot_count(Pointer hStation);

    Pointer domain_station_get_pilots(Pointer hStation);

    /**
     * @brief: 从当前站点得到操作员
     *
     * @param  hStation 为输入的当前站点指针
     *
     * @return OperatorH类型，输出为操作员指针
     */
    Pointer domain_station_get_pilot_at(Pointer hStation, int nIndex);

    /**
     * @brief: 从当前站点得到指挥器
     *
     * @param  hStation 为输入的当前站点指针
     *
     * @return CommanderH类型，输出为运载工具的指挥器指针
     */
    Pointer domain_station_get_commander(Pointer hStation);

    /**
     * @brief: 执行飞行
     *
     * @param  hCommander 为输入的指挥器指针
     * @param  pszKey     为输入的飞检状态
     * @param pfnCallback 为输入的发动运载工具输出的pfnCallback数据
     */
    void domain_commander_launch(Pointer hCommander,
                                 String pszKey,
                                 Callback pfnCallback);

    void domain_commander_setout(Pointer hCommander,
                                 String pszKey,
                                 Callback pfnCallback);

    void domain_commander_gohome(Pointer hCommander,
                                 String pszKey,
                                 Callback pfnCallback);

    void domain_commander_cutoff(Pointer hCommander,
                                 String pszKey,
                                 Callback pfnCallback);

    Pointer domain_commander_default_project(Pointer hCommander);

    Callback domain_commander_get_default_project_callback(Pointer hCommander);

    void domain_commander_set_default_project_callback(Pointer hCommander,
                                                       Callback pfnCallback);

    Pointer domain_commander_get_current_project(Pointer hCommander);

    Boolean domain_commander_current_project_is_vaild(Pointer hCommander);

    /**
     * @brief: 获取指挥器当前工程从同步工程是否有没有完成的工程
     *
     * @param  hCommander 为当前工程所在的指挥器
     *
     * @return bool类型，工程是否是没有完成的
     */
    Boolean domain_commander_current_project_is_getFromPGSuccess(Pointer hCommander);

    Callback domain_commander_get_current_project_callback(Pointer hCommander);

    void domain_commander_set_current_project_callback(Pointer hCommander,
                                                       Callback pfnCallback);

    void domain_commander_project_begin(Pointer hCommander,
                                        String pszPrjName,
                                        TimeBO.ByReference pPrjDateTime,
                                        String pszPrjLocation,
                                        Callback pfnCallback);

    void domain_commander_project_select(Pointer hCommander, Pointer[] pahUnit);

    void domain_commander_project_selects(Pointer hCommander, Pointer[] pahUnits, int count);

    void domain_commander_project_end(Pointer hCommander, String pszPrjName);

    void domain_commander_project_cancel(Pointer hCommander, String pszPrjName);

    void domain_commander_order_begin(Pointer hCommander,
                                      String pszOrderName,
                                      Callback pfnCallback);

    void domain_commander_order_select(Pointer hCommander, Pointer[] pahUnits, int count);

    void domain_commander_order_end(Pointer hCommander, String pszOrderName);

    void domain_commander_order_cancel(Pointer hCommander, String pszOrderName);

    /**
     * @brief: 创建一个任务计划
     *
     * @param  hCommander  为输入的指挥器指针
     * @param  pszPlanName 为输入的任务计划的名字
     * @param  hPlayer     为输入的执行任务设备（产品和组件），它可能是一架飞机，一辆指控车和任务载荷组合
     * @param  pfnCallback 为输入的从任务计划输出的pfnCallback数据
     */
    void domain_commander_plan_begin(Pointer hCommander,
                                     String pszPlanName,
                                     Pointer hPlayer,
                                     Callback pfnCallback);
    /**
     * @brief: 把任务目标添加到当前任务计划
     *
     * @param  hCommander 为输入的指挥器指针
     * @param  hTarget    为输入的任务目标，可以是点、线、面
     */
    void domain_commander_plan_pretreat(Pointer hCommander, Pointer hTarget);

    /**
     * @brief: 指定测区生成航点、动作点
     *
     * @param  hCommander 为输入的指挥器指针
     * @param  hZone      为输入的任务测区，测区类型为面
     */
    void domain_commander_plan_build(Pointer hCommander, Pointer hZone);

    /**
     * @brief: 结束一个计划
     *
     * @param  hCommander  为输入的指挥器指针
     * @param  pszPlanName 为输入的任务计划的名称，它与domain_commander_plan_begin开始的名称相同
     */
    void domain_commander_plan_end(Pointer hCommander, String pszPlanName);

    void domain_commander_plan_cancel(Pointer hCommander, String pszPlanName);

    String domain_commander_plan_to_json(Pointer hCommander, Pointer hPlan);

    /* -------------------------------------------------------------------- */
    /*      service.h related functions                                     */
    /* -------------------------------------------------------------------- */

    void domain_service_get_resource(Pointer hServiece, String pszUrl, Callback pfnCallback);

    void domain_service_post_resource(Pointer hServiece, String pszUrl, Callback pfnCallback);

    void domain_service_put_resource(Pointer hServiece, String pszUrl, Callback pfnCallback);

    void domain_service_delete_resource(Pointer hServiece, String pszUrl, Callback pfnCallback);

    /* -------------------------------------------------------------------- */
    /*      solution.h related functions                                    */
    /* -------------------------------------------------------------------- */

    int domain_solution_get_vehicle_count(Pointer hSln);

    int domain_solution_get_station_count(Pointer hSln);

    int domain_solution_get_service_count(Pointer hSln);

    int domain_solution_get_operator_count(Pointer hSln);

    Pointer domain_solution_get_vehicles(Pointer hSln, Pointer hVehicles, IntByReference count);

    Pointer domain_solution_get_stations(Pointer hSln, Pointer hstations, IntByReference count);

    Pointer domain_solution_get_services(Pointer hSln, Pointer hservices, IntByReference count);

    Pointer domain_solution_get_operators(Pointer hSln, Pointer hOperators, IntByReference count);

    /**
     * @brief: 获得在解决方案中选择的运载工具
     *
     * @param  hSln   为输入的当前的解决方案
     * @param  nIndex 为输入的当前解决方案中选择的运载工具的索引
     *
     * @return VehicleH类型，返回解决方案所选择的运载工具
     */
    Pointer domain_solution_get_vehicle_at(Pointer hSln, int nIndex);

    /**
     * @brief: 获得解决方案中指定序号的站点
     *
     * @param  hSln   为输入的当前的解决方案句柄
     * @param  nIndex 为输入的当前解决方案中选择的站点索引
     *
     * @return StationH类型，返回解决方案中所选择的站点句柄
     */
    Pointer domain_solution_get_station_at(Pointer hSln, int nIndex);

    Pointer domain_solution_get_service_at(Pointer hSln, int nIndex);

    Pointer domain_solution_get_operator_at(Pointer hSln, int nIndex);

    /* -------------------------------------------------------------------- */
    /*      account.h related functions                                     */
    /* -------------------------------------------------------------------- */

    /**
     * @brief: 登录帐户
     *
     * @param  pszUsername 为输入的用户名
     * @param  pszPassword 为输入的用户名的密码
     *
     * @return AccountH类型，返回当前用户句柄
     */
    Pointer domain_account_login(String pszUsername, String pszPassword);

    void domain_account_logout(Pointer hAccount);


    String domain_account_get_username(Pointer hAccount);

    String domain_account_get_user_token(Pointer hAccount);

    int domain_account_get_user_state(Pointer hAccount);

    String domain_account_get_user_avatar(Pointer hAccount);

    String domain_account_get_user_authorization(Pointer hAccount);


    int domain_account_get_solution_count(Pointer hAccount);

    Pointer domain_account_get_solutions(Pointer hAccount);

    /**
     * @brief: 获得当前账户下指定序号的解决方案类
     *
     * @param  hAccount 为输入的账户句柄
     * @param  nIndex   为输入的账户选择的解决方案索引
     *
     * @return SolutionH类型，返回账户选择的解决方案句柄
     */
    Pointer domain_account_get_solution_at(Pointer hAccount, int nIndex);

    /**
     * 通过运载工具获取飞行平台
     * @param hVehicle
     * @return
     */
    Pointer domain_vehicle_get_carrier(Pointer hVehicle);

    /**
     * 获取载荷个数
     * @param hVehicle
     * @return
     */
    int domain_vehicle_get_payload_count(Pointer hVehicle);

    /**
     * 通过运载工具获取载荷列表
     * @param hVehicle
     * @param hPayloads
     * @param count
     */
    void domain_vehicle_get_payloads(Pointer hVehicle, Pointer[] hPayloads, IntByReference count);

    Pointer domain_operator_get_product(Pointer hOperator);

    Pointer domain_station_get_product(Pointer hStation);

    Pointer domain_vehicle_get_product(Pointer hVehicle);

    Pointer domain_payload_get_product(Pointer hPayload);

    /**
     *  获取飞行平台最小转弯半径
     * @param hCarrier 飞行平台
     * @return
     */
    double domain_carrier_get_orbit_radius(Pointer hCarrier);

    /**
     * 设置飞行平台最小转弯半径
     * @param hCarrier
     * @param radius
     */
    void domain_carrier_set_orbit_radius(Pointer hCarrier, double radius);

    /**
     * 获取最大坡度角
     * @param hCarrier
     * @return
     */
    double domain_carrier_get_max_climb_angle(Pointer hCarrier);

    void domain_carrier_set_max_climb_angle(Pointer hCarrier, double angle);

    Pointer domain_solution_get_product(Pointer hSln);

    /**
     * 获取该站点的状态（是否创建工单）
     * @param hStation
     * @return
     */
    boolean domain_station_is_create_order(Pointer hStation);

    /**
     * 设置站点状态（是否创建工单）
     * @param hStation
     * @param isOK
     */
    void domain_station_set_is_create_order(Pointer hStation, boolean isOK);

    /**
     * 获取该设备的状态（是否创建工单）
     * @param hVehicle
     * @return
     */
    boolean domain_vehicle_is_occupied(Pointer hVehicle);

    /**
     * 设置设备状态（是否创建工单）
     * @param hVehicle
     * @param isOK
     */
    void domain_vehicle_set_is_occupied(Pointer hVehicle, boolean isOK);
}
