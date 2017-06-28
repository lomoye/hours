package com.lomoye.hours.core.manager.impl;

import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.manager.AbstractManager;
import com.lomoye.common.util.DateUtil;
import com.lomoye.hours.core.dao.ItemRecordMapper;
import com.lomoye.hours.core.domain.ItemRecord;
import com.lomoye.hours.core.manager.ItemRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.lomoye.common.util.DateUtil.getDailyStartTime;


@Component
public class ItemRecordManagerImpl extends AbstractManager<ItemRecord> implements ItemRecordManager{

    @Autowired
    private ItemRecordMapper mapper;


    @Override
    protected BasicMapper<Long, ItemRecord> getMapper() {
        return mapper;
    }

    @Override
    public ItemRecord findTodayItemRecord() {
        Date day = DateUtil.getDailyStartTime(new Date());

        ItemRecord itemRecord = new ItemRecord();
        itemRecord.setDay(day);

        return mapper.selectOne(itemRecord);
    }


}
