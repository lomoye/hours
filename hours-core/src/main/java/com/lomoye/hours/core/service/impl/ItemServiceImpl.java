package com.lomoye.hours.core.service.impl;

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
    public ItemRecord addItemRecord(Long userId, ItemRecord itemRecord) {
        ItemRecord oldRecord = itemRecordManager.findTodayItemRecord(userId, itemRecord.getItemId());

        if (oldRecord == null) {
            itemRecord.setDay(DateUtil.getDailyStartTime(new Date()));
            itemRecordManager.save(itemRecord);
            saveItemParamValue(userId, itemRecord);
        } else {
            itemRecord.setId(oldRecord.getId());
            itemRecord.setDay(oldRecord.getDay());
            updateItemParamValue(userId, itemRecord);
        }


        return itemRecord;
    }

    @Override
    public Item addItem(Long userId, Item item) {
        item.setUserId(userId);
        itemManager.save(item);

        List<ItemParam> itemParams = item.getItemParams();

        int index = 0;
        for (ItemParam itemParam : itemParams) {
            itemParam.setUserId(userId);
            itemParam.setItemId(item.getId());
            itemParam.setIndex(index++);
            itemParam.setType("number");//目前只有数字类型

            itemParamManager.save(itemParam);
        }

        return item;
    }


    private void updateItemParamValue(Long userId, ItemRecord itemRecord) {
        itemParamValueManager.deleteByItemRecordId(userId, itemRecord.getId());

        batchSaveItemParamValue(userId, itemRecord);
    }

    private void saveItemParamValue(Long userId, ItemRecord itemRecord) {
        batchSaveItemParamValue(userId, itemRecord);
    }

    private void batchSaveItemParamValue(Long userId, ItemRecord itemRecord) {
        List<ItemParamValue> itemParamValueList = itemRecord.getItemParamValueList();
        if (CollectionUtils.isEmpty(itemParamValueList)) {
            return;
        }
        for (ItemParamValue itemParamValue : itemParamValueList) {
            itemParamValue.setId(null);
            itemParamValue.setUserId(userId);
            itemParamValue.setItemId(itemRecord.getItemId());
            itemParamValue.setItemRecordId(itemRecord.getId());
            itemParamValue.setDay(itemRecord.getDay());
            itemParamValueManager.save(itemParamValue);
        }
    }
}
