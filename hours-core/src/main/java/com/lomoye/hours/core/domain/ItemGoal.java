package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

import java.util.Date;

/**
 * Created by lomoye on 2017/8/17.
 * 基于项目的目标
 */
public class ItemGoal extends CommonDomain {
    private Long userId;

    private Long itemId;

    private Date startTime;

    private Date endTime;

    private String goalNum;//目标值

    private Long creditRate;//倍率 每改变0.1,增加多少积分.

    private String status;//目标的状态


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getGoalNum() {
        return goalNum;
    }

    public void setGoalNum(String goalNum) {
        this.goalNum = goalNum;
    }

    public Long getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(Long creditRate) {
        this.creditRate = creditRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
