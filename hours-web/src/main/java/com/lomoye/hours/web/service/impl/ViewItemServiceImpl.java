package com.lomoye.hours.web.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.lomoye.common.exception.BusinessException;
import com.lomoye.common.util.DateUtil;
import com.lomoye.hours.core.constant.ErrorCode;
import com.lomoye.hours.core.domain.Item;
import com.lomoye.hours.core.domain.ItemParam;
import com.lomoye.hours.core.domain.ItemParamValue;

import com.lomoye.hours.core.domain.ItemRecord;
import com.lomoye.hours.core.manager.ItemManager;
import com.lomoye.hours.core.manager.ItemParamManager;
import com.lomoye.hours.core.manager.ItemParamValueManager;
import com.lomoye.hours.core.manager.ItemRecordManager;
import com.lomoye.hours.web.dto.ItemRecordDto;
import com.lomoye.hours.web.dto.ItemRecordTableDto;
import com.lomoye.hours.web.service.ViewItemService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lomoye on 2017/6/30.
 *
 */
@Service
public class ViewItemServiceImpl implements ViewItemService {
    @Autowired
    private ItemManager itemManager;
    @Autowired
    private ItemParamManager itemParamManager;
    @Autowired
    private ItemParamValueManager itemParamValueManager;
    @Autowired
    private ItemRecordManager itemRecordManager;


    @Override
    public List<ItemRecordDto> listItemRecordDto(Long userId, Long itemId) {
        Item item = itemManager.getById(itemId);
        if (item == null) {
            throw new BusinessException(ErrorCode.PARAMETER_IS_ILLEGAL, "项目不存在");
        }

        List<ItemParamValue> itemParamValues = itemParamValueManager.listByItemIdOrderByDay(userId, itemId, "asc");
        if (CollectionUtils.isEmpty(itemParamValues)) {
            return new ArrayList<>();
        }

        Map<Long, List<ItemParamValue>> paramValueMap = Multimaps.asMap(Multimaps.index(itemParamValues, new Function<ItemParamValue, Long>() {
            @Override
            public Long apply(ItemParamValue input) {
                return input.getItemParamId();
            }
        }));

        List<ItemParam> itemParams = itemParamManager.findByItemId(userId, itemId);

        List<ItemRecordDto> dtos = new ArrayList<>();
        for (ItemParam itemParam : itemParams) {
            List<ItemParamValue> values = paramValueMap.get(itemParam.getId());
            if (CollectionUtils.isEmpty(values)) {
                continue;
            }
            ItemRecordDto dto = ItemRecordDto.valueOf(itemParam, values, item);
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public ItemRecordTableDto reportItemRecord(Long userId, Long itemId) {
        Item item = itemManager.getById(itemId);
        if (item == null) {
            throw new BusinessException(ErrorCode.PARAMETER_IS_ILLEGAL, "项目不存在");
        }

        List<ItemParamValue> itemParamValues = itemParamValueManager.listByItemIdOrderByDay(userId, itemId, "desc");
        if (CollectionUtils.isEmpty(itemParamValues)) {
            return null;
        }

        Map<String, List<ItemParamValue>> paramValueMap = Multimaps.asMap(Multimaps.index(itemParamValues, new Function<ItemParamValue, String>() {
            @Override
            public String apply(ItemParamValue input) {
                return DateUtil.format(input.getDay(), "yyyy-MM-dd");
            }
        }));

        //common info
        List<ItemRecord> itemRecords = itemRecordManager.findByItemId(userId, itemId);
        Map<String, ItemRecord> itemRecordMap = Maps.uniqueIndex(itemRecords, new Function<ItemRecord, String>() {
            @Override
            public String apply(ItemRecord input) {
                return DateUtil.format(input.getDay(), "yyyy-MM-dd");
            }
        });

        List<ItemParam> itemParams = itemParamManager.findByItemId(userId, itemId);
        ItemRecordTableDto itemRecordTableDto = new ItemRecordTableDto();
        itemRecordTableDto.setItemParams(itemParams);

        List<Map<String, String>> recordMaps = new ArrayList<>();
        for (Map.Entry<String, List<ItemParamValue>> entry : paramValueMap.entrySet()) {
            Map<String, String> recordMap = new HashMap<>();
            recordMap.put("date", entry.getKey());//时间的key约定成date
            recordMap.put("desc", itemRecordMap.get(entry.getKey()).getDesc());
            for (ItemParamValue value : entry.getValue()) {
                recordMap.put(value.getItemParamId().toString(), value.getValue());
            }

            recordMaps.add(recordMap);
        }

        itemRecordTableDto.setRecordMaps(recordMaps);
        return itemRecordTableDto;
    }
}
