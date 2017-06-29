package com.lomoye.hours.web.dto;

import java.util.List;

/**
 * Created by lomoye on 2017/6/29.
 * 数据报表的数据组织
 */
public class ItemRecordDto {
    private String name;

    private List<String> xAxis;

    private List<String> yAxis;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getxAxis() {
        return xAxis;
    }

    public void setxAxis(List<String> xAxis) {
        this.xAxis = xAxis;
    }

    public List<String> getyAxis() {
        return yAxis;
    }

    public void setyAxis(List<String> yAxis) {
        this.yAxis = yAxis;
    }
}
