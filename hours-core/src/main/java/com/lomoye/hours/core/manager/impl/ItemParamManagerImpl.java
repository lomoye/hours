package com.lomoye.hours.core.manager.impl;


import com.google.common.base.Preconditions;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.dao.OrderCondition;
import com.lomoye.common.manager.AbstractManager;
import com.lomoye.hours.core.dao.ItemParamMapper;
import com.lomoye.hours.core.domain.ItemParam;
import com.lomoye.hours.core.manager.ItemParamManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ItemParamManagerImpl extends AbstractManager<ItemParam> implements ItemParamManager{

    @Autowired
    private ItemParamMapper mapper;


    @Override
    protected BasicMapper<Long, ItemParam> getMapper() {
        return mapper;
    }

    @Override
    public List<ItemParam> findByItemId(Long itemId) {
        Preconditions.checkArgument(itemId != null);
        ItemParam condition = new ItemParam();
        condition.setItemId(itemId);

        List<OrderCondition> orderConditions = new ArrayList<>();
        orderConditions.add(new OrderCondition("`index`", "asc"));

        return nonEmptyList(listByCondition(condition, orderConditions));
    }
}
