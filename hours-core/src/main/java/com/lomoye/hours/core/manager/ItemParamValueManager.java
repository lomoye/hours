package com.lomoye.hours.core.manager;


import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.ItemParamValue;


public interface ItemParamValueManager extends DomainManager<Long,ItemParamValue> {
    void deleteByItemRecordId(Long itemRecordId);
}
