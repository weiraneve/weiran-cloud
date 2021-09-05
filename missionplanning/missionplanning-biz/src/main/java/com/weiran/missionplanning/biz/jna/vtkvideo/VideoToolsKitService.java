package com.weiran.missionplanning.biz.jna.vtkvideo;

import com.weiran.missionplanning.biz.jna.bo.JAVVTKPacketBO;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;


/**
 * discription:VideoToolsKit SDK
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/1 9:29
 **/
public interface VideoToolsKitService extends Library {

    /**
     * 目前：linux版本的sdk存在错误
     * 本地：J:\系统与应用软件部\0文件传输\0部门内部文件交互\冯云迪\JVTKSln\VideoToolsKit\VideoToolsKit-SDK-Release-2021-07-19-01\lib64
     * D:\sdk-dll\VtkSDK
     */
//    VideoToolsKitService INSTANCE = (VideoToolsKitService) Native.load(
//            Platform.isLinux() ? "video/libJAVVideoToolsKit" : "video/JAVVideoToolsKit4", VideoToolsKitService.class);

    VideoToolsKitService INSTANCE = (VideoToolsKitService) Native.load("J:\\系统与应用软件部\\0文件传输\\0部门内部文件交互\\冯云迪\\JVTKSln\\VideoToolsKit\\VideoToolsKit-SDK-Release-2021-07-19-01\\lib64\\JAVVideoToolsKit4", VideoToolsKitService.class);
    /**
     * 创建一个video tools kit实例
     *
     * @return vtk 实例指针
     */
    Pointer jav_vtk_create();

    /**
     * 销毁一个video tools kit实例
     *
     * @param vtk: video tools kit实例指针
     */
    void jav_vtk_destroy(Pointer vtk);

    /**
     * @param vtk:            video tools kit实例指针
     * @param url:            本地视频文件路径、udp地址(格式udp://127.0.0.1:8080)、RTSP地址、RTMP地址
     * @param is_cache_packet 是否缓存原始视频帧
     * @param is_decode_frame 是否解码视频
     * @param is_mux_ts       是否复用全动态视频(FMV，TS格式)
     * @return 0成功，非0失败
     * @brief 初始化并开始读取或接收处理
     */
    int jav_vtk_open(Pointer vtk, String url, boolean is_cache_packet,
                     boolean is_decode_frame, boolean is_mux_ts);

    /**
     * 关闭实例
     *
     * @param vtk: video tools kit实例指针
     */
    void jav_vtk_close(Pointer vtk);

    /**
     * 设置是否缓存视频码流数据
     *
     * @param vtk:             video tools kit实例指针
     * @param is_cache_packet: 是否缓存
     * @detailed description: 如果设置了true，则应该不断的调用jav_vtk_retrieve_packet，否则内存占用不断升高
     */
    void jav_vtk_set_is_cache_packet(Pointer vtk, boolean is_cache_packet);

    /**
     * @param vtk:             video tools kit实例指针
     * @param is_decode_frame: 是否解码
     * @brief 设置是否解码视频码流
     * @details description: 如果设置了true，则解码，如为false，则不解码
     */
    void jav_vtk_set_is_decode_frame(Pointer vtk, boolean is_decode_frame);

    /**
     * 设置缓存视频帧数，当缓存超过这个数值时最老的一帧将被删除，默认大小为10
     *
     * @param vtk:  video tools kit实例指针
     * @param size: 要缓存的帧数
     */
    void jav_vtk_set_cache_size(Pointer vtk, int size);

    /**
     * @param vtk:    video tools kit实例指针
     * @param is_mux: 是否处理
     * @brief 设置是否开始复用GIS系统FMV格式，符合MISB标准的视频
     * @details description: 如果设置了true，则应该不断的调用jav_getLatest_muxed_ts_packet，否则内存累积
     */
    boolean jav_set_is_muxing_ts_data_link_local_set(Pointer vtk, boolean is_mux);


    /**
     * @param vtk: video tools kit实例指针
     * @return 视频帧结构指针，用完时需要删除，必须使用jav_vtk_packet_free函数来删除
     * @brief 获取一帧视频码流数据
     */
    JAVVTKPacketBO jav_vtk_retrieve_packet(Pointer vtk);

    /**
     * 视频帧结构指针，用完时需要删除，必须使用jav_vtk_packet_free函数来删除
     *
     * @param packet
     */
    void jav_vtk_packet_free(Pointer packet);


    /**
     * @param vtk: video tools kit实例指针
     * @return 返回错误码
     * @brief 获取错误码，当获取不到视频帧时可检查错误码；\n
     * 如果错误码不是ErrocOk，则表示发生了错误或者读取到文件结尾了；\n
     * 如果错误码时ErrocOk，则可能未读取到或未收到正确数据，或解码失败了，可以继续调用retrieve
     */
    int jav_vtk_get_erroc(Pointer vtk);

    /**
     * @param vtk: video tools kit实例指针
     * @return 错误描述的字符串
     * @brief 获取错误描述
     */
    String jav_vtk_get_error_description(Pointer vtk);
}
