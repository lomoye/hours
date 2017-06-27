package com.lomoye.hours.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by lomoye on 2017/6/27.
 * 项目的单日记录
 */
public class ItemRecord extends CommonDomain {
    private Date day;//日期

    private List<ItemRecordParam> itemRecordParams;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public List<ItemRecordParam> getItemRecordParams() {
        return itemRecordParams;
    }

    public void setItemRecordParams(List<ItemRecordParam> itemRecordParams) {
        this.itemRecordParams = itemRecordParams;
    }
}
