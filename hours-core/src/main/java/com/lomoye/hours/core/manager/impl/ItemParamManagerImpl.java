package com.lomoye.hours.core.manager.impl;


import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.manager.AbstractManager;
import com.lomoye.hours.core.dao.ItemParamMapper;
import com.lomoye.hours.core.domain.ItemParam;
import com.lomoye.hours.core.manager.ItemParamManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ItemParamManagerImpl extends AbstractManager<ItemParam> implements ItemParamManager{

    @Autowired
    private ItemParamMapper mapper;


    @Override
    protected BasicMapper<Long, ItemParam> getMapper() {
        return mapper;
    }
}
