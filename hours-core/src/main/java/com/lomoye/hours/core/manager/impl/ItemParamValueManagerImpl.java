package com.lomoye.hours.core.manager.impl;


import com.google.common.base.Preconditions;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.manager.AbstractManager;
import com.lomoye.hours.core.dao.ItemParamValueMapper;
import com.lomoye.hours.core.domain.ItemParamValue;
import com.lomoye.hours.core.manager.ItemParamValueManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ItemParamValueManagerImpl extends AbstractManager<ItemParamValue> implements ItemParamValueManager{

    @Autowired
    private ItemParamValueMapper mapper;


    @Override
    protected BasicMapper<Long, ItemParamValue> getMapper() {
        return mapper;
    }

    @Override
    public void deleteByItemRecordId(Long itemRecordId) {
        Preconditions.checkArgument(itemRecordId != null);
        ItemParamValue condition = new ItemParamValue();
        condition.setItemRecordId(itemRecordId);

        mapper.deleteByCondition(condition);
    }
}
