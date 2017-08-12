package com.lomoye.hours.web.websocket;

import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.core.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;


/**
 * Created by lomoye on 2017/8/12.
 */
@Service
public class WebSocketPusher implements InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketPusher.class);

    @Autowired
    private UserManager userManager;

    @Override
    public void afterPropertiesSet() throws Exception {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    LOGGER.info("take message..");
                    Message message = MessageHolder.takeMessage();
                    if (message == null) {
                        LOGGER.warn("get message null..");
                        continue;
                    }
                    LOGGER.info("take message success|content={}|userId={}", message.getContent(), message.getUserId());

                    for (Map.Entry<String, Session> entry : SessionHolder.clients.entrySet()) {
                        Session session = entry.getValue();
                        if (!session.isOpen()) {
                            continue;
                        }
                        try {
                            User user = userManager.getById(message.getUserId());
                            if (user == null) {
                                LOGGER.warn("user null..|userId={}", message.getUserId());
                                continue;
                            }
                            session.getBasicRemote().sendText(user.getNick() + ":" + message.getContent());
                        } catch (IOException e) {
                            LOGGER.warn("ioException", e);
                        }
                    }

                }

            }
        };

        new Thread(task).start();
    }
}
