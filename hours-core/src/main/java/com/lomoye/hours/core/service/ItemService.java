package com.lomoye.hours.core.service;

import com.lomoye.hours.core.domain.ItemRecord;

import java.util.List;

/**
 * Created by lomoye on 2017/6/28.
 * 项目接口
 */
public interface ItemService {
    ItemRecord addItemRecord(ItemRecord itemRecord);

    List<ItemRecord> listItemRecord(Long itemId);
}
