package com.lomoye.hours.core.manager;


import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.ItemRecord;

import java.util.Date;
import java.util.List;


public interface ItemRecordManager extends DomainManager<Long,ItemRecord> {
    ItemRecord findTodayItemRecord(Long userId, Long itemId);

    ItemRecord findSomeDayItemRecord(Long userId, Long itemId, Date day);

    List<ItemRecord> findByItemId(Long userId, Long itemId);
}
