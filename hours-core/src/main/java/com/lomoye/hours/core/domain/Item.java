package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

import java.util.List;

/**
 * Created by lomoye on 2017/6/27.
 * 项目类
 */
public class Item extends CommonDomain {
    private String name;//项目名

    private String desc;//描述

    private List<ItemParam> itemParams;

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
}
