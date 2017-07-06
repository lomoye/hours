package com.lomoye.hours.core.manager;


import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.ItemParam;

import java.util.List;


public interface ItemParamManager extends DomainManager<Long,ItemParam> {
    List<ItemParam> findByItemId(Long userId, Long itemId);

    long countByItemId(Long userId, Long itemId);
}
