package com.lomoye.hours.web.dto;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.lomoye.hours.core.domain.Item;
import com.lomoye.hours.core.domain.ItemParam;
import com.lomoye.hours.core.domain.ItemParamValue;
import java.util.Date;
import java.util.List;

/**
 * Created by lomoye on 2017/6/29.
 * 数据报表的数据组织
 */
public class ItemRecordDto {
    private String name;//项目名

    private String desc;//描述

    private String unit;

    private String yAxisName;//y轴数据名字

    private List<String> yAxis;//y轴数据

    private List<Date> days;//日期 xAxis

    public static ItemRecordDto valueOf(ItemParam itemParam, List<ItemParamValue> values, Item item) {
        ItemRecordDto dto = new ItemRecordDto();

        dto.setName(item.getName());
        dto.setDesc(item.getDesc());
        dto.setUnit(itemParam.getUnit());
        dto.setyAxisName(itemParam.getDisplayName());

        dto.setDays(FluentIterable.from(values).transform(new Function<ItemParamValue, Date>() {
            @Override
            public Date apply(ItemParamValue input) {
                return input.getDay();
            }
        }).toList());


        dto.setyAxis(FluentIterable.from(values).transform(new Function<ItemParamValue, String>() {
            @Override
            public String apply(ItemParamValue input) {
                return input.getValue();
            }
        }).toList());

        return dto;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getyAxisName() {
        return yAxisName;
    }

    public void setyAxisName(String yAxisName) {
        this.yAxisName = yAxisName;
    }

    public List<String> getyAxis() {
        return yAxis;
    }

    public void setyAxis(List<String> yAxis) {
        this.yAxis = yAxis;
    }

    public List<Date> getDays() {
        return days;
    }

    public void setDays(List<Date> days) {
        this.days = days;
    }
}
