package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

/**
 * Created by lomoye on 2017/9/21.
 * 用户建议
 */
public class UserSuggest extends CommonDomain {
    private Long userId;

    private String userNick;

    private String title;//标题

    private String content;//内容

    private String status;//状态

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
