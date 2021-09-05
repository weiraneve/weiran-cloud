package com.weiran.missionplanning.biz.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * discription:
 *
 * @author wujinzhu@weiran.com
 * @date 2021/6/7 17:04
 */
@Slf4j
@WebListener
@Order(2)
public class SocketIoListener implements ServletContextListener {
    @Value("${socket.io.hostname}")
    private String hostname;

    @Value("${socket.io.port}")
    private int port;

    @Value("${security.oauth2.resource.user-info-uri}")
    private String url;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 启动Socket服务
        SocketIo.setUrl(url);
        SocketIo socketIo = new SocketIo();
        socketIo.startServer(hostname,port);
        log.info("====================================== 启动SocketIo服务"+hostname);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        // 关闭启动SocketIo服务
        SocketIo socketIo = new SocketIo();
        socketIo.stopServerIo();
        log.info("====================================== 关闭SocketIo服务");
    }
}
