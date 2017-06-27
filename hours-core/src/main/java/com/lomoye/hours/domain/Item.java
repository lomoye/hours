package com.lomoye.hours.domain;

/**
 * Created by lomoye on 2017/6/27.
 * 项目类
 */
public class Item extends CommonDomain {
    private String name;//项目名

    private String desc;//描述


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
}
