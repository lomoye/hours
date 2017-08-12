package com.lomoye.hours.web.websocket;


/**
 * Created by lomoye on 2017/8/12.
 *
 */
public class Message {
    private Long userId;

    private String userName;

    private String content;

    public Message() {

    }

    public Message(Long userId, String content) {
        this.userId = userId;
        this.userName = userName;
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
