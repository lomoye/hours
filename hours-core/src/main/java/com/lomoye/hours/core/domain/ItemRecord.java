package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

import java.util.Date;


/**
 * Created by lomoye on 2017/6/27.
 * 项目的单日记录
 */
public class ItemRecord extends CommonDomain {
    private Long itemId;

    private Date day;//日期

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
