package com.weiran.missionplanning.biz.socket;


import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.jouav.commom.until.HttpClientUtils;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;



/**
 * discription:
 *
 * @author wujinzhu@weiran.com
 * @date 2021/6/7 17:11
 */
@Service
@Slf4j
public class SocketIo {
    private static SocketIOServer socketIOServer;
    public static String url;

    public static void setUrl(String url) {
        SocketIo.url = url;
    }

    public void startSocketIo(String hostname, int port) {
        // 配置
        Configuration conf = new Configuration();
        // 指定要主机ip地址，这个和页面请求ip地址一致
        conf.setHostname(hostname);
        // 指定端口号
        conf.setPort(port);
        // 设置最大的WebSocket帧内容长度限制
        conf.setMaxFramePayloadLength(1024 * 1024);
        // 设置最大HTTP内容长度限制
        conf.setMaxHttpContentLength(1024 * 1024);

        // 权限判断，如果没有 token，或者 token 为空，则返回false，拒绝socket的链接
        conf.setAuthorizationListener(hd -> {
            String auth_token = hd.getSingleUrlParam("access_token");
            return !StringUtil.isNullOrEmpty(auth_token);
        });
        socketIOServer = new SocketIOServer(conf);

        //添加connect事件，当客户端发起连接时调用，本文中将clientid与sessionid存入数据库
        //方便后面发送消息时查找到对应的目标client,
        ConnectListener connect = new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient client) {
                HandshakeData hd = client.getHandshakeData();
                String authToken = hd.getSingleUrlParam("access_token");
                String userName = getusername(authToken);
                if (userName != null) {
                    SessionUtil.userId_socket_Map.put(userName, client);
                }
                log.info("============>用户 " + userName + " 连接成功,当前在线人数: " + SessionUtil.userId_socket_Map.size());
            }
        };

        //添加@OnDisconnect事件，客户端断开连接时调用，刷新客户端信息
        DisconnectListener onDisconnect = new DisconnectListener() {
            @Override
            public void onDisconnect(SocketIOClient client) {
                HandshakeData hd = client.getHandshakeData();
                String authToken = hd.getSingleUrlParam("access_token");
                String userName = getusername(authToken);
                if (userName != null) {
                    SessionUtil.userId_socket_Map.remove(userName);
                }
                log.info("============>用户 " + userName + " 退出连接,当前在线人数: " + SessionUtil.userId_socket_Map.size());
            }
        };

        // 添加客户端
        socketIOServer.addConnectListener(connect);
        socketIOServer.addDisconnectListener(onDisconnect);
        socketIOServer.start();

    }
    /**
     * 根据access_token获取用户名称
     */
    public String getusername(String userToken) {
        String username = null;
        try {
            String msg = HttpClientUtils.getNew(url + "?access_token=" + userToken);
            JSONObject jsonObject = JSONObject.parseObject(msg);
            if (jsonObject != null) {
                username = jsonObject.getString("name");
            }
        } catch (Exception e) {
            log.error("用户信息解析失败。。。。。。。。。。。。。。" + userToken);
        }
        return username;
    }


    public void pushArr(String type, Object content, List<String> user) {

        // 获取全部开始播放视频客户端
        if (user != null) {
            user.forEach(e -> {
                if (!StringUtils.isEmpty(e) && SessionUtil.userId_socket_Map.containsKey(e)) {
                    SocketIOClient socket = SessionUtil.userId_socket_Map.get(e);
                    socket.sendEvent(type, content);
                }
            });
        }

    }

    public void pushArr(String type, Object content, String user) {

        // 获取全部开始播放视频客户端
        if (user != null) {
            if (!StringUtils.isEmpty(user) && SessionUtil.userId_socket_Map.containsKey(user)
//                    && SessionUtil.playUser_socket_Map.containsKey(user)
                    ) {
                log.info("**********推给 " + user + "用户");
                SocketIOClient socket = SessionUtil.userId_socket_Map.get(user);
                socket.sendEvent(type, content);
            }
        }

    }

    /**
     * @Title: startServer
     * @Description: 启动服务
     */
    public void startServer(String hostname, int port) {
        if (socketIOServer == null) {
            // Thread 线程
            new Thread(() -> startSocketIo(hostname, port)).start();
        }
    }

    /**
     * @Title: stopSocketio
     * @Description: 停止服务
     */
    public void stopServerIo() {
        if (socketIOServer != null) {
            socketIOServer.stop();
            socketIOServer = null;
        }
    }

}
