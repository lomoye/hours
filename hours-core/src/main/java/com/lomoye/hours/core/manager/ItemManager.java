package com.lomoye.hours.core.manager;


import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.Item;

import java.util.List;


public interface ItemManager extends DomainManager<Long, Item> {
    List<Item> listByUserId(Long userId);
}
