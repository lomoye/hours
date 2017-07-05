package com.lomoye.hours.core.manager.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.dao.OrderCondition;
import com.lomoye.common.manager.AbstractManager;
import com.lomoye.hours.core.domain.Item;
import com.lomoye.hours.core.manager.ItemManager;
import com.lomoye.hours.core.dao.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ItemManagerImpl extends AbstractManager<Item> implements ItemManager {

    @Autowired
    private ItemMapper mapper;


    @Override
    protected BasicMapper<Long, Item> getMapper() {
        return mapper;
    }

    @Override
    public List<Item> listByUserId(Long userId) {
        Preconditions.checkArgument(userId != null);
        Item condition = new Item();
        condition.setUserId(userId);
        List<Item> items = listByCondition(condition, Lists.<OrderCondition>newArrayList());
        return nonEmptyList(items);
    }
}
