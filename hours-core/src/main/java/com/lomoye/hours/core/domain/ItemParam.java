package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

/**
 * Created by lomoye on 2017/6/27.
 * 记录的参数类
 */
public class ItemParam extends CommonDomain {
    private Long userId;

    private Long itemId;

    private String type;

    private String unit;//计量单位  exp. kg, cm, km

    private String displayName;//文案名

    private Integer index;//排序

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
