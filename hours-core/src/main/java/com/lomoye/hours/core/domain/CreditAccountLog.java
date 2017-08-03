package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

import java.util.Date;

/**
 * Created by lomoye on 2017/8/3.
 * 积分账户日志
 */
public class CreditAccountLog extends CommonDomain {
    private Long userId;

    private Date day;//日期

    private String type;//引起账户变化的类型  比如记录信息加1分

    private String memo;//备注信息，方便以后查问题

    private String content;//日志内容

    private Long beforeCredit;//变化前的积分

    private Long afterCredit;//变化后的积分

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBeforeCredit() {
        return beforeCredit;
    }

    public void setBeforeCredit(Long beforeCredit) {
        this.beforeCredit = beforeCredit;
    }

    public Long getAfterCredit() {
        return afterCredit;
    }

    public void setAfterCredit(Long afterCredit) {
        this.afterCredit = afterCredit;
    }
}
