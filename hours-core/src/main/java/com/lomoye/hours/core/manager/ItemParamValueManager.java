package com.lomoye.hours.core.manager;


import com.google.common.collect.FluentIterable;
import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.ItemParamValue;

import java.util.List;


public interface ItemParamValueManager extends DomainManager<Long,ItemParamValue> {
    void deleteByItemRecordId(Long itemRecordId);

    List<ItemParamValue> listByItemRecordIds(FluentIterable<Long> transform);
}
