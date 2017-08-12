package com.lomoye.hours.web.websocket;

/**
 * Created by lomoye on 2017/8/12.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * 功能说明：websocket处理类, 使用J2EE7的标准
 * 切忌直接在该连接处理类中加入业务处理代码
 *
 */
@ServerEndpoint("/ws/chat/{relationId}")
public class WebsocketEndPoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebsocketEndPoint.class);

    /**
     * 打开连接时触发
     */
    @OnOpen
    public void onOpen(@PathParam("relationId") String relationId, Session session) {
        System.out.println("Websocket Start Connecting:" + relationId);
        SessionHolder.put(relationId, session);
    }

    /**
     * 收到客户端消息时触发
     */
    @OnMessage
    public String onMessage(@PathParam("relationId") String relationId, String message) {
        MessageHolder.addMessage(new Message(Long.valueOf(relationId), message));
        return null;
    }

    /**
     * 异常时触发
     */
    @OnError
    public void onError(@PathParam("relationId") String relationId, Throwable throwable, Session session) {
        System.out.println("Websocket Connection Exception:" + relationId);
        LOGGER.info(throwable.getMessage(), throwable);
        SessionHolder.remove(relationId);
    }

    /**
     * 关闭连接时触发
     */
    @OnClose
    public void onClose(@PathParam("relationId") String relationId, Session session) {
        System.out.println("Websocket Close Connection:" + relationId);
        SessionHolder.remove(relationId);
    }

}