package com.lomoye.hours.web.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;
import com.lomoye.common.exception.BusinessException;
import com.lomoye.hours.core.domain.Item;
import com.lomoye.hours.core.domain.ItemParam;
import com.lomoye.hours.core.domain.ItemParamValue;

import com.lomoye.hours.core.manager.ItemManager;
import com.lomoye.hours.core.manager.ItemParamManager;
import com.lomoye.hours.core.manager.ItemParamValueManager;
import com.lomoye.hours.web.dto.ItemRecordDto;
import com.lomoye.hours.web.service.ViewItemService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
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


    @Override
    public List<ItemRecordDto> listItemRecordDto(Long userId, Long itemId) {
        Item item = itemManager.getById(itemId);
        if (item == null) {
            throw new BusinessException("20000", "项目不存在");
        }

        List<ItemParamValue> itemParamValues = itemParamValueManager.listByItemIdOrderByDay(userId, itemId);
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
}
