package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

/**
 * Created by lomoye on 2017/6/28.
 * 参数记录的值
 */
public class ItemParamValue extends CommonDomain {
    private Long itemRecordId;

    private Long itemParamId;

    private Long itemId;

    private String value;

    public Long getItemRecordId() {
        return itemRecordId;
    }

    public void setItemRecordId(Long itemRecordId) {
        this.itemRecordId = itemRecordId;
    }

    public Long getItemParamId() {
        return itemParamId;
    }

    public void setItemParamId(Long itemParamId) {
        this.itemParamId = itemParamId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}