package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

import java.util.Date;

/**
 * Created by lomoye on 2017/8/11.
 * 版本笔记
 */
public class VersionNote extends CommonDomain {
    private String content;

    private Date day;//上线时间

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
