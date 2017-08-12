package com.lomoye.hours.web.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lomoye on 2017/8/12.
 *
 */
public class MessageHolder {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionHolder.class);

    private static BlockingQueue<Message> messageQueue = new ArrayBlockingQueue<>(10000);

    private MessageHolder() {

    }


    public static void addMessage(Message message) {
        try {
            messageQueue.put(message);
        } catch (InterruptedException e) {
            LOGGER.warn("addMessage error|messageId={}", message.getUserId(), e);
        }
    }

    public static Message takeMessage() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            LOGGER.warn("takeMessage error", e);
            return null;
        }
    }
}
