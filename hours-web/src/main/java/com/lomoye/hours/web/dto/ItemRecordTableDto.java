package com.lomoye.hours.web.dto;


import com.lomoye.hours.core.domain.ItemParam;

import java.util.List;
import java.util.Map;

/**
 * Created by lomoye on 2017/7/5.
 * table展示所需数据格式
 */
public class ItemRecordTableDto {
    private String name;//项目名

    private List<ItemParam> itemParams;//id当 key  对应下面Map里的key

    private List<Map<String, String>> recordMaps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemParam> getItemParams() {
        return itemParams;
    }

    public void setItemParams(List<ItemParam> itemParams) {
        this.itemParams = itemParams;
    }

    public List<Map<String, String>> getRecordMaps() {
        return recordMaps;
    }

    public void setRecordMaps(List<Map<String, String>> recordMaps) {
        this.recordMaps = recordMaps;
    }
}
