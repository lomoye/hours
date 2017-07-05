package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

import java.util.Date;
import java.util.List;


/**
 * Created by lomoye on 2017/6/27.
 * 项目的单日记录
 */
public class ItemRecord extends CommonDomain {
    private Long userId;

    private Long itemId;

    private Date day;//日期

    /**
     * 非持久化
     */
    private List<ItemParamValue> itemParamValueList;

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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public List<ItemParamValue> getItemParamValueList() {
        return itemParamValueList;
    }

    public void setItemParamValueList(List<ItemParamValue> itemParamValueList) {
        this.itemParamValueList = itemParamValueList;
    }
}
