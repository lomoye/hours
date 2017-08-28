package com.lomoye.hours.core.service.impl;

import com.lomoye.common.exception.BusinessException;
import com.lomoye.common.util.DateUtil;
import com.lomoye.hours.core.constant.ErrorCode;
import com.lomoye.hours.core.domain.*;
import com.lomoye.hours.core.enums.CreditAccountLogType;
import com.lomoye.hours.core.manager.*;
import com.lomoye.hours.core.service.CreditAccountService;
import com.lomoye.hours.core.service.ItemService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger LOGGER = LoggerFactory.getLogger(CreditAccountServiceImpl.class);

    @Autowired
    private ItemRecordManager itemRecordManager;
    @Autowired
    private ItemParamValueManager itemParamValueManager;
    @Autowired
    private ItemManager itemManager;
    @Autowired
    private ItemParamManager itemParamManager;
    @Autowired
    private CreditAccountService creditAccountService;
    @Autowired
    private CreditAccountLogManager creditAccountLogManager;

    @Override
    public ItemRecord addItemRecord(Long userId, ItemRecord itemRecord) {
        ItemRecord oldRecord = itemRecordManager.findTodayItemRecord(userId, itemRecord.getItemId());

        if (oldRecord == null) {
            itemRecord.setDay(DateUtil.getDailyStartTime(new Date()));
            itemRecord.setUserId(userId);
            itemRecordManager.save(itemRecord);
            saveItemParamValue(userId, itemRecord);
        } else {
            itemRecord.setId(oldRecord.getId());
            itemRecord.setDay(oldRecord.getDay());
            itemRecord.setUserId(oldRecord.getUserId());
            itemRecordManager.update(itemRecord);
            updateItemParamValue(userId, itemRecord);
        }

        addCreditUtilSuccess(userId, itemRecord);
        return itemRecord;
    }

    private void addCreditUtilSuccess(Long userId, ItemRecord itemRecord) {
        //今天记录过了就没有奖励了，一天记录数据只奖励一次
        long count = creditAccountLogManager.countTodayByType(CreditAccountLogType.ITEM_RECORD, userId);
        if (count > 0) {
            LOGGER.warn("addCredit, but itemRecord count > 0|count={}", count);
            return;
        }

        creditAccountService.addCreditUtilSuccess(userId, 1L, CreditAccountLogType.ITEM_RECORD, itemRecord.getId().toString());
    }

    @Override
    public Item addItem(Long userId, Item item) {
        item.setUserId(userId);
        item.setIsDelete(0);
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

    @Override
    public ItemRecord makeupItemRecord(Long userId, ItemRecord itemRecord) {
        itemRecord.setUserId(userId);
        itemRecord.setDay(DateUtil.getDailyStartTime(itemRecord.getDay()));

        ItemRecord oldRecord = itemRecordManager.findSomeDayItemRecord(userId, itemRecord.getItemId(), itemRecord.getDay());
        if (oldRecord != null) {
            LOGGER.info("no need make up, already has record|userId={}|day={}", itemRecord.getDay());
            throw new BusinessException(ErrorCode.PARAMETER_IS_ILLEGAL, "这一天已经有记录了，无需弥补记录");
        }

        itemRecordManager.save(itemRecord);
        saveItemParamValue(userId, itemRecord);

        return itemRecord;
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
