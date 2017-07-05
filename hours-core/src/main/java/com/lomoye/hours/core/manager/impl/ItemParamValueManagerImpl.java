package com.lomoye.hours.core.manager.impl;


import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.dao.OrderCondition;
import com.lomoye.common.manager.AbstractManager;
import com.lomoye.hours.core.dao.ItemParamValueMapper;
import com.lomoye.hours.core.domain.ItemParamValue;
import com.lomoye.hours.core.manager.ItemParamValueManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ItemParamValueManagerImpl extends AbstractManager<ItemParamValue> implements ItemParamValueManager{

    @Autowired
    private ItemParamValueMapper mapper;


    @Override
    protected BasicMapper<Long, ItemParamValue> getMapper() {
        return mapper;
    }

    @Override
    public void deleteByItemRecordId(Long userId, Long itemRecordId) {
        Preconditions.checkArgument(userId != null && itemRecordId != null);
        ItemParamValue condition = new ItemParamValue();
        condition.setUserId(userId);
        condition.setItemRecordId(itemRecordId);

        mapper.deleteByCondition(condition);
    }

    @Override
    public List<ItemParamValue> listByItemIdOrderByDay(Long userId, Long itemId) {
        Preconditions.checkArgument(userId != null && itemId != null);
        ItemParamValue condition = new ItemParamValue();
        condition.setItemId(itemId);
        return nonEmptyList(mapper.selectByCondition(condition, Lists.newArrayList(new OrderCondition("`day`", "asc"))));
    }


}
