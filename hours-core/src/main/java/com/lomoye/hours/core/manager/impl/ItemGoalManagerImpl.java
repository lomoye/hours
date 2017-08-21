package com.lomoye.hours.core.manager.impl;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.dao.OrderCondition;
import com.lomoye.hours.core.dao.ItemGoalMapper;
import com.lomoye.hours.core.domain.ItemGoal;
import com.lomoye.hours.core.enums.ItemGoalStatus;
import com.lomoye.hours.core.manager.ItemGoalManager;
import com.lomoye.common.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ItemGoalManagerImpl extends AbstractManager<ItemGoal> implements ItemGoalManager{

    @Autowired
    private ItemGoalMapper mapper;


    @Override
    protected BasicMapper<Long, ItemGoal> getMapper() {
        return mapper;
    }

    @Override
    public long countItemGoal(String status, Long userId) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(status) && userId != null);
        ItemGoal condition = new ItemGoal();
        condition.setStatus(status);
        condition.setUserId(userId);
        return count(condition);
    }

    @Override
    public List<ItemGoal> listAllItemGoalOfUser(Long userId) {
        Preconditions.checkArgument(userId != null);
        ItemGoal condition = new ItemGoal();
        condition.setUserId(userId);
        return nonEmptyList(listByCondition(condition, new ArrayList<OrderCondition>()));
    }

    @Override
    public List<ItemGoal> getAllStartGoal() {
        ItemGoal condition = new ItemGoal();
        condition.setStatus(ItemGoalStatus.START);
        return listByCondition(condition, new ArrayList<OrderCondition>());
    }
}
