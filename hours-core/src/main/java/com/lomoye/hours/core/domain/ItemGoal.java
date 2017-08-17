package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

import java.util.Date;

/**
 * Created by lomoye on 2017/8/17.
 * 基于项目的目标
 */
public class ItemGoal extends CommonDomain {
    private Long userId;

    private Date startTime;

    private Date endTime;

    private String target;//目标值

    private Long creditRate;//倍率 每改变1,增加多少积分.

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Long getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(Long creditRate) {
        this.creditRate = creditRate;
    }
}
