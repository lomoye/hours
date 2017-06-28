package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

/**
 * Created by lomoye on 2017/6/28.
 * 参数记录的值
 */
public class ItemParamValue extends CommonDomain {
    private Long ItemParamId;

    private Long itemId;

    private String value;

    public Long getItemParamId() {
        return ItemParamId;
    }

    public void setItemParamId(Long itemParamId) {
        ItemParamId = itemParamId;
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
