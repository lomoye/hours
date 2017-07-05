package com.lomoye.hours.core.service;

import com.lomoye.hours.core.domain.Item;
import com.lomoye.hours.core.domain.ItemRecord;



/**
 * Created by lomoye on 2017/6/28.
 * 项目接口
 */
public interface ItemService {
    ItemRecord addItemRecord(Long userId, ItemRecord itemRecord);

    Item addItem(Long userId, Item item);
}
