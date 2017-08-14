package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

import java.util.List;

/**
 * Created by lomoye on 2017/6/27.
 * 项目类
 */
public class Item extends CommonDomain {
    private Long userId;

    private String name;//项目名

    private String desc;//描述

    private Integer isDelete;

    private List<ItemParam> itemParams;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<ItemParam> getItemParams() {
        return itemParams;
    }

    public void setItemParams(List<ItemParam> itemParams) {
        this.itemParams = itemParams;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
