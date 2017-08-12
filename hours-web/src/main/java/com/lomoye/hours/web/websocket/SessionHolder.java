package com.lomoye.hours.web.websocket;



import javax.websocket.Session;
import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;


/**
 * 功能说明：用来存储业务定义的sessionId和连接的对应关系
 * 利用业务逻辑中组装的sessionId获取有效连接后进行后续操作
 * 作者：liuxing(2014-12-26 02:32)
 */
public class SessionHolder {

    public static Map<String, Session> clients = new ConcurrentHashMap<>();


    public static void put(String relationId, Session session) {
        clients.put(relationId, session);
    }

    public static Session get(String relationId) {
        return clients.get(relationId);
    }

    public static void remove(String relationId) {
        clients.remove(relationId);
    }
}
