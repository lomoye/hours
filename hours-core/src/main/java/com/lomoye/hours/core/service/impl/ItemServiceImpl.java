package com.lomoye.hours.core.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.lomoye.common.util.DateUtil;
import com.lomoye.hours.core.domain.Item;
import com.lomoye.hours.core.domain.ItemParam;
import com.lomoye.hours.core.domain.ItemParamValue;
import com.lomoye.hours.core.domain.ItemRecord;
import com.lomoye.hours.core.manager.ItemManager;
import com.lomoye.hours.core.manager.ItemParamManager;
import com.lomoye.hours.core.manager.ItemParamValueManager;
import com.lomoye.hours.core.manager.ItemRecordManager;
import com.lomoye.hours.core.service.ItemService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


/**
 * Created by lomoye on 2017/6/28.
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRecordManager itemRecordManager;
    @Autowired
    private ItemParamValueManager itemParamValueManager;
    @Autowired
    private ItemManager itemManager;
    @Autowired
    private ItemParamManager itemParamManager;

    @Override
    public ItemRecord addItemRecord(ItemRecord itemRecord) {
        ItemRecord oldRecord = itemRecordManager.findTodayItemRecord(itemRecord.getItemId());

        if (oldRecord == null) {
            itemRecord.setDay(DateUtil.getDailyStartTime(new Date()));
            itemRecordManager.save(itemRecord);
            saveItemParamValue(itemRecord);
        } else {
            itemRecord.setId(oldRecord.getId());
            itemRecord.setDay(oldRecord.getDay());
            updateItemParamValue(itemRecord);
        }


        return itemRecord;
    }

    @Override
    public Item addItem(Item item) {
        itemManager.save(item);

        List<ItemParam> itemParams = item.getItemParams();

        int index = 0;
        for (ItemParam itemParam : itemParams) {
            itemParam.setItemId(item.getId());
            itemParam.setIndex(index++);
            itemParam.setType("number");//目前只有数字类型

            itemParamManager.save(itemParam);
        }

        return item;
    }


    private void updateItemParamValue(ItemRecord itemRecord) {
        itemParamValueManager.deleteByItemRecordId(itemRecord.getId());

        batchSaveItemParamValue(itemRecord);
    }

    private void saveItemParamValue(ItemRecord itemRecord) {
        batchSaveItemParamValue(itemRecord);
    }

    private void batchSaveItemParamValue(ItemRecord itemRecord) {
        List<ItemParamValue> itemParamValueList = itemRecord.getItemParamValueList();
        if (CollectionUtils.isEmpty(itemParamValueList)) {
            return;
        }
        for (ItemParamValue itemParamValue : itemParamValueList) {
            itemParamValue.setId(null);
            itemParamValue.setItemId(itemRecord.getItemId());
            itemParamValue.setItemRecordId(itemRecord.getId());
            itemParamValue.setDay(itemRecord.getDay());
            itemParamValueManager.save(itemParamValue);
        }
    }
}
