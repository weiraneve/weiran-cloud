package com.weiran.missionplanning.biz.socket;

import com.corundumstudio.socketio.SocketIOClient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * discription:
 *
 * @author wujinzhu@weiran.com
 * @date 2021/6/7 16:56
 */
public class SessionUtil {
    /**
     * 保存所有的 video ：socket 连接
     * String: 用户名
     * SocketIOClient ： socket客户端
     */
    public static Map<String, SocketIOClient> userId_socket_Map = new ConcurrentHashMap<>();

    /**
     * 记录播放视频的客户端
     */
//    public static Map<String, SocketIOClient> playUser_socket_Map = new ConcurrentHashMap<>();
    public static Map<String, String> playUser_socket_Map = new ConcurrentHashMap<>();

    /**
     * 记录播放视频的客户端
     */
    public static Map<String, String> playUser_socket_Map1 = new ConcurrentHashMap<>();

    /**
     * 记录结束视频的客户端
     */
    public static Map<String, SocketIOClient> finishUser_socket_Map = new ConcurrentHashMap<>();
}
