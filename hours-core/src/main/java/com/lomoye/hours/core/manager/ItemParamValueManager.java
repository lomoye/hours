package com.lomoye.hours.core.manager;



import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.ItemParamValue;

import java.util.List;


public interface ItemParamValueManager extends DomainManager<Long,ItemParamValue> {
    void deleteByItemRecordId(Long userId, Long itemRecordId);

    List<ItemParamValue> listByItemIdOrderByDay(Long userId, Long itemId, String orderBy);
}
