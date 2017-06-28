package com.lomoye.hours.core.manager.impl;

import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.manager.AbstractManager;
import com.lomoye.hours.core.dao.ItemRecordMapper;
import com.lomoye.hours.core.domain.ItemRecord;
import com.lomoye.hours.core.manager.ItemRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ItemRecordManagerImpl extends AbstractManager<ItemRecord> implements ItemRecordManager{

    @Autowired
    private ItemRecordMapper mapper;


    @Override
    protected BasicMapper<Long, ItemRecord> getMapper() {
        return mapper;
    }
}
