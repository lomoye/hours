package com.lomoye.hours.core.manager;

import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.ItemGoal;

import java.util.List;


public interface ItemGoalManager extends DomainManager<Long,ItemGoal> {
    long countItemGoal(String status, Long userId);

    List<ItemGoal> listAllItemGoalOfUser(Long userId);

    List<ItemGoal> getAllStartGoal();
}
